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
    protected CopyOnWriteArrayList<ChangeEventListener> listenerList;
    protected Object                                    bean;
    protected String                                    name;
    protected T                                         value;


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

    public Object getBean() { return bean; }

    public String getName() { return name; }


    // ******************** Event Handling ************************************
    public void setOnPropertyChanged(final ChangeEventListener listener) { addListener(listener); }
    public void addListener(final ChangeEventListener listener) {
        if (null == listenerList) { listenerList = new CopyOnWriteArrayList<>(); }
        if (!listenerList.contains(listener)) listenerList.add(listener);
    }
    public void removeListener(final ChangeEventListener listener) {
        if (null == listenerList) { return; }
        if (listenerList.contains(listener)) listenerList.remove(listener);
    }
    public void removeAllListeners() {
        if (null == listenerList) { return; }
        listenerList.clear();
    }

    public void fireEvent(final ChangeEvent event) {
        if (null == listenerList) { listenerList = new CopyOnWriteArrayList<>(); }
        listenerList.forEach(listener -> listener.onChangeEvent(event));
    }
}
