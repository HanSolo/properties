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

/**
 * Created by hansolo on 24.10.17.
 */
public class DoubleProperty extends ReadOnlyDoubleProperty {

    // ******************** Constructors **************************************
    public DoubleProperty() {
        super(null, null, 0d);
    }
    public DoubleProperty(final double value) {
        super(null, null, value);
    }
    public DoubleProperty(final Object bean, final String name, final double value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Double value) {
        willChange(this.value, value);
        final double oldValue = this.value;
        this.value = value;
        if (null != listenerList && !listenerList.isEmpty()) { fireEvent(new ChangeEvent<>(this, oldValue, this.value)); }
        didChange(oldValue, this.value);
    }
    public void set(final double VALUE) { setValue(VALUE); }
}
