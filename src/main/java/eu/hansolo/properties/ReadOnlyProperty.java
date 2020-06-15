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

import java.util.concurrent.CopyOnWriteArrayList;


public abstract class ReadOnlyProperty<T extends Object> {
    protected CopyOnWriteArrayList<ChangeListener> changeListeners;
    protected Object                               bean;
    protected String                               name;
    protected T                                    value;


    // ******************** Constructors **************************************
    public ReadOnlyProperty() {
        this(null, null, null);
    }
    public ReadOnlyProperty(final T value) {
        this(null, null, value);
    }
    public ReadOnlyProperty(final Object bean, final String name, final T value) {
        this.bean  = bean;
        this.name  = name;
        this.value = value;
    }


    // ******************** Methods *******************************************
    public final T getValue() { return value; }

    protected void willChange(final T oldValue, final T newValue) {}

    protected void didChange(final T oldValue, final T newValue) {}

    protected void invalidated() {}

    public Object getBean() { return bean; }

    public String getName() { return name; }


    // ******************** Event Handling ************************************
    public void addListener(final ChangeListener listener) {
        if (null == changeListeners) { changeListeners = new CopyOnWriteArrayList<>(); }
        if (!changeListeners.contains(listener)) changeListeners.add(listener);
    }
    public void removeListener(final ChangeListener listener) {
        if (null == changeListeners) { return; }
        if (changeListeners.contains(listener)) changeListeners.remove(listener);
    }
    public void removeAllListeners() {
        if (null == changeListeners) { return; }
        changeListeners.clear();
    }

    public void fireEvent(final ChangeEvent event) {
        if (null == changeListeners) { return; }
        changeListeners.forEach(listener -> listener.onEvent(event));
    }
}
