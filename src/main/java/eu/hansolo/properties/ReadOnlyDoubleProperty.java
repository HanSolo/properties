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


public class ReadOnlyDoubleProperty extends ReadOnlyProperty<Double> {

    // ******************** Constructors **************************************
    public ReadOnlyDoubleProperty() {
        super(null, null, 0d);
    }
    public ReadOnlyDoubleProperty(final double value) {
        super(null, null, value);
    }
    public ReadOnlyDoubleProperty(final Object bean, final String name, final double value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    public double get() { return value; }
}
