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


public class CharProperty extends ReadOnlyCharProperty {
    protected CharProperty propertyToUpdate;
    protected boolean      bound;
    protected boolean      bidirectional;


    // ******************** Constructors **************************************
    public CharProperty() {
        super(null, null, ' ');
    }
    public CharProperty(final char value) {
        super(null, null, value);
    }
    public CharProperty(final Object bean, final String name, final char value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    public void setValue(final Character value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final char value) { setValue(value); }
    protected void setValue(final Character value, final CharProperty property) {
        willChange(this.value, value);
        final char oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
    }

    protected void bind(final CharProperty property) {
        this.value = property.getValue();
        property.setPropertyToUpdate(this);
        propertyToUpdate = null;
        bound            = true;
        bidirectional    = false;
    }
    protected void bindBidirectional(final CharProperty property) {
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

    protected void setPropertyToUpdate(final CharProperty property) {
        setPropertyToUpdate(property, false);
    }
    protected void setPropertyToUpdate(final CharProperty property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        this.value            = property.getValue();
        this.bound            = true;
        this.bidirectional    = true;
    }
}
