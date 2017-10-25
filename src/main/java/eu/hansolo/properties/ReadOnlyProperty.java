package eu.hansolo.properties;

import java.util.concurrent.CopyOnWriteArrayList;


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
