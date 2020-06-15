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


public class LongProperty extends ReadOnlyLongProperty {
    protected LongProperty propertyToUpdate;
    protected boolean      bound;
    protected boolean      bidirectional;


    // ******************** Constructors **************************************
    public LongProperty() {
        super(null, null, 0l);
    }
    public LongProperty(final long value) {
        super(null, null, value);
    }
    public LongProperty(final Object bean, final String name, final long value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    public void setValue(final Long value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final long value) { setValue(value); }
    protected void setValue(final Long value, final LongProperty property) {
        willChange(this.value, value);
        final long oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
    }

    protected void bind(final LongProperty property) {
        this.value = property.getValue();
        property.setPropertyToUpdate(this);
        propertyToUpdate = null;
        bound            = true;
        bidirectional    = false;
    }
    protected void bindBidirectional(final LongProperty property) {
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

    protected void setPropertyToUpdate(final LongProperty property) {
        setPropertyToUpdate(property, false);
    }
    protected void setPropertyToUpdate(final LongProperty property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        this.value            = property.getValue();
        this.bound            = true;
        this.bidirectional    = true;
    }
}
