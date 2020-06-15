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


public class DoubleProperty extends ReadOnlyDoubleProperty {
    protected DoubleProperty propertyToUpdate;
    protected DoubleProperty propertyBoundTo;
    protected boolean        bound;
    protected boolean        bidirectional;


    // ******************** Constructors **************************************
    public DoubleProperty() {
        this(null, null, 0d);
    }
    public DoubleProperty(final double value) {
        this(null, null, value);
    }
    public DoubleProperty(final String name, final double value) {
        this(null, name, value);
    }
    public DoubleProperty(final Object bean, final String name, final double value) {
        super(bean, name, value);
        this.propertyToUpdate = null;
        this.propertyBoundTo  = null;
        this.bound            = false;
        this.bidirectional    = false;
    }


    // ******************** Methods *******************************************
    public void setValue(final Double value) {
        if (bound && !bidirectional) { throw new IllegalArgumentException("A bound value cannot be set."); }
        setValue(value, null);
    }
    public void set(final double value) { setValue(value); }
    protected void setValue(final Double value, final DoubleProperty property) {
        willChange(this.value, value);
        final Double oldValue = this.value;
        this.value = value;
        if (null == property && null != this.propertyToUpdate) {
            this.propertyToUpdate.setValue(value, this);
        }
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
        invalidated();
    }

    protected void bind(final DoubleProperty property) {
        this.propertyBoundTo = property;
        this.value           = this.propertyBoundTo.getValue();
        propertyBoundTo.setPropertyToUpdate(this);
        propertyToUpdate = null;
        this.bound       = true;
    }
    protected boolean isBound() { return this.bound; }

    protected void bindBidirectional(final DoubleProperty property) {
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

    protected void setPropertyToUpdate(final DoubleProperty property) {
        setPropertyToUpdate(property, false);
    }
    protected void setPropertyToUpdate(final DoubleProperty property, final boolean bidirectional) {
        this.propertyToUpdate = property;
        if (null == property) {
            this.bidirectional = false;
        } else {
            this.value = property.getValue();
            this.bidirectional = bidirectional;
        }
    }
}
