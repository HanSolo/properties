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

/**
 * Created by hansolo on 24.10.17.
 */
public abstract class ReadOnlyProperty<T extends Object> {
    protected final CopyOnWriteArrayList<ChangeEventListener> listenerList = new CopyOnWriteArrayList<>();
    protected       Object  bean;
    protected       String  name;
    protected       T       value;


    // ******************** Constructors **************************************
    public ReadOnlyProperty() {
        this(null, null, null);
    }
    public ReadOnlyProperty(final T VALUE) {
        this(null, null, VALUE);
    }
    public ReadOnlyProperty(final Object BEAN, final String NAME, final T VALUE) {
        bean     = BEAN;
        name     = NAME;
        value    = VALUE;
    }


    // ******************** Methods *******************************************
    public final T getValue() { return value; }

    protected void invalidated() {}

    public Object getBean() { return bean; }

    public String getName() { return name; }


    // ******************** Event Handling ************************************
    public void setOnPropertyChanged(final ChangeEventListener LISTENER) { addListener(LISTENER); }
    public void addListener(final ChangeEventListener LISTENER) { if (!listenerList.contains(LISTENER)) listenerList.add(LISTENER); }
    public void removeListener(final ChangeEventListener LISTENER) { if (listenerList.contains(LISTENER)) listenerList.remove(LISTENER); }
    public void removeAllListeners() { listenerList.clear(); }

    public void fireEvent(final ChangeEvent EVENT) { listenerList.forEach(listener -> listener.onChangeEvent(EVENT));}
}
