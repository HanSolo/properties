package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ObjectProperty<T> extends ReadOnlyObjectProperty<T> {

    // ******************** Constructors **************************************
    public ObjectProperty() {
        super(null, null, null);
    }
    public ObjectProperty(final T VALUE) {
        super(null, null, VALUE);
    }
    public ObjectProperty(final Object BEAN, final String NAME, final T VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final T VALUE) {
        T oldValue = value;
        value      = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final T VALUE) { setValue(VALUE); }
}

