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


public class ChangeEvent<T extends Object> {
    private final Object src;
    private final T      oldValue;
    private final T      value;


    // ******************** Constructors **************************************
    public ChangeEvent(final Object src, final T oldValue, final T value) {
        this.src      = src;
        this.oldValue = oldValue;
        this.value    = value;
    }


    // ******************** Methods *******************************************
    public Object getSource() { return src; }

    public T getOldValue() { return oldValue; }

    public T getValue() { return value; }
}
