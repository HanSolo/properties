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


public class BooleanProperty extends ReadOnlyBooleanProperty {
    protected ReadOnlyBooleanProperty propertyBoundTo;
    protected boolean                 bound;


    // ******************** Constructors **************************************
    public BooleanProperty() {
        this(null, null, false);
    }
    public BooleanProperty(final boolean value) {
        this(null, null, Boolean.valueOf(value));
    }
    public BooleanProperty(final String name, final boolean value) {
        this(null, name, value);
    }
    public BooleanProperty(final Object bean, final String name, final boolean value) {
        super(bean, name, value);
        this.propertyBoundTo = null;
        this.bound           = false;
    }


    // ******************** Methods *******************************************
    public void setValue(final Boolean value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final boolean value) { setValue(value); }
    protected void setValue(final Boolean value, final BooleanProperty property) {
        willChange(this.value, value);
        final Boolean oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
        invalidated();
    }

    public void unset() { setValue(getInitialValue()); }

    public void setInitialValue(final Boolean initialValue) { this.initialValue = initialValue; }

    public void bind(final ReadOnlyBooleanProperty property) {
        this.propertyBoundTo = property;
        this.value           = this.propertyBoundTo.getValue();
        propertyBoundTo.setPropertyToUpdate(this);
        propertyToUpdate = null;
        this.bound       = true;
    }
    public boolean isBound() { return this.bound; }

    public void bindBidirectional(final BooleanProperty property) {
        setPropertyToUpdate(property, true);
        property.setPropertyToUpdate(this, true);
        this.propertyBoundTo = property;
        this.bound           = true;
    }
    public boolean isBoundBidirectional() { return this.bidirectional; }

    public void unbind() {
        if (null != this.propertyToUpdate) {
            this.propertyToUpdate.unsetPropertyToUpdate();
            this.propertyToUpdate.unbind();
            this.propertyToUpdate = null;
        }
        if (null != this.propertyBoundTo) {
            this.propertyBoundTo.unsetPropertyToUpdate();
            this.propertyBoundTo = null;
        }
        this.bound         = false;
        this.bidirectional = false;
    }

    protected void setPropertyToUpdate(final BooleanProperty property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        if (null == property) {
            this.bidirectional = false;
        } else {
            this.value = property.getValue();
            this.bidirectional = bidirectional;
        }
    }
}
