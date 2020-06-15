/*
 * Copyright (c) 2017 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.properties;


public class IntegerProperty extends ReadOnlyIntegerProperty {
    protected IntegerProperty propertyToUpdate;
    protected boolean         bound;
    protected boolean         bidirectional;


    // ******************** Constructors **************************************
    public IntegerProperty() {
        super(null, null, 0);
    }
    public IntegerProperty(final int value) {
        super(null, null, value);
    }
    public IntegerProperty(final Object bean, final String name, final int value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    public void setValue(final Integer value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final int value) { setValue(value); }
    protected void setValue(final Integer value, final IntegerProperty property) {
        willChange(this.value, value);
        final int oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
        invalidated();
    }

    protected void bind(final IntegerProperty property) {
        this.value = property.getValue();
        property.setPropertyToUpdate(this);
        propertyToUpdate = null;
        bound            = true;
        bidirectional    = false;
    }
    protected void bindBidirectional(final IntegerProperty property) {
        setPropertyToUpdate(property);
        property.setPropertyToUpdate(this);
        this.bound         = true;
        this.bidirectional = true;
    }
    protected boolean isBound() { return this.bound; }

    protected void unbind() {
        this.propertyToUpdate = null;
        this.bound            = false;
        this.bidirectional    = false;
    }

    protected void setPropertyToUpdate(final IntegerProperty property) {
        setPropertyToUpdate(property, false);
    }
    protected void setPropertyToUpdate(final IntegerProperty property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        this.value            = property.getValue();
        this.bound            = true;
        this.bidirectional    = true;
    }
}
