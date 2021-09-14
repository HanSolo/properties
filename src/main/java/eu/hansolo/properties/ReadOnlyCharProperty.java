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


public class ReadOnlyCharProperty extends ReadOnlyProperty<Character> {
    protected CharProperty propertyToUpdate;
    protected boolean      bidirectional;


    // ******************** Constructors **************************************
    public ReadOnlyCharProperty() {
        super(null, null, ' ');
    }
    public ReadOnlyCharProperty(final char value) {
        super(null, null, value);
    }
    public ReadOnlyCharProperty(final Object bean, final String name, final char value) {
        super(bean, name, value);
        this.propertyToUpdate = null;
        this.bidirectional    = false;
    }


    // ******************** Methods *******************************************
    public char get() { return value; }

    protected void setPropertyToUpdate(final CharProperty property) {
        this.propertyToUpdate = property;
        this.bidirectional    = false;
    }
    protected void unsetPropertyToUpdate() {
        this.propertyToUpdate = null;
        this.bidirectional    = false;
    }
}
