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


public class ObjectProperty<T> extends ReadOnlyObjectProperty<T> {
    protected ObjectProperty<T> propertyToUpdate;
    protected ObjectProperty<T> propertyBoundTo;
    protected boolean           bound;
    protected boolean           bidirectional;


    // ******************** Constructors **************************************
    public ObjectProperty() {
        this(null, null, null);
    }
    public ObjectProperty(final T value) {
        this(null, null, value);
    }
    public ObjectProperty(final String name, final T value) {
        this(null, name, value);
    }
    public ObjectProperty(final Object bean, final String name, final T value) {
        super(bean, name, value);
        this.propertyToUpdate = null;
        this.propertyBoundTo  = null;
        this.bound            = false;
        this.bidirectional    = false;
    }


    // ******************** Methods *******************************************
    public void setValue(final T value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final T value) { setValue(value); }
    protected void setValue(final T value, final ObjectProperty<T> property) {
        willChange(this.value, value);
        final T oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
        invalidated();
    }

    protected void bind(final ObjectProperty<T> property) {
        this.propertyBoundTo = property;
        this.value           = this.propertyBoundTo.getValue();
        propertyBoundTo.setPropertyToUpdate(this);
        propertyToUpdate = null;
        this.bound       = true;
    }
    protected boolean isBound() { return this.bound; }

    protected void bindBidirectional(final ObjectProperty<T> property) {
        setPropertyToUpdate(property, true);
        property.setPropertyToUpdate(this, true);
        this.propertyBoundTo = property;
        this.bound           = true;
    }
    protected boolean isBoundBidirectional() { return this.bidirectional; }

    protected void unbind() {
        if (null != this.propertyToUpdate) {
            this.propertyToUpdate.setPropertyToUpdate(null);
            this.propertyToUpdate.unbind();
            this.propertyToUpdate = null;
        }
        if (null != this.propertyBoundTo) {
            this.propertyBoundTo.setPropertyToUpdate(null);
            this.propertyBoundTo = null;
        }
        this.bound         = false;
        this.bidirectional = false;
    }

    protected void setPropertyToUpdate(final ObjectProperty<T> property) {
        setPropertyToUpdate(property, false);
    }
    protected void setPropertyToUpdate(final ObjectProperty<T> property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        if (null == property) {
            this.bidirectional = false;
        } else {
            this.value = property.getValue();
            this.bidirectional = bidirectional;
        }
    }
}

