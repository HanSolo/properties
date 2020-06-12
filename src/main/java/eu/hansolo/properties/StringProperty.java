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
public class StringProperty extends ReadOnlyStringProperty {

    // ******************** Constructors **************************************
    public StringProperty() {
        super(null, null, "");
    }
    public StringProperty(final String value) {
        super(null, null, value);
    }
    public StringProperty(final Object bean, final String name, final String value) {
        super(bean, name, value);
    }


    // ******************** Methods *******************************************
    protected void setValue(final String value) {
        willChange(this.value, value);
        final String oldValue = this.value;
        this.value = value;
        fireEvent(new ChangeEvent<>(this, oldValue, this.value));
        didChange(oldValue, this.value);
    }
    public void set(final String value) { setValue(value); }
}
