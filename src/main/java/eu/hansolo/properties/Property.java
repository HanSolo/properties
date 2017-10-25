package eu.hansolo.properties;

public abstract class Property<T extends Object> extends ReadOnlyProperty<T> {


    // ******************** Constructors **************************************
    public Property() {
        this(null, null, null);
    }
    public Property(final T VALUE) {
        this(null, null, VALUE);
    }
    public Property(final Object BEAN, final String NAME, final T VALUE) {
        bean     = BEAN;
        name     = NAME;
        value    = VALUE;
    }


    // ******************** Methods *******************************************
    protected void setValue(final T VALUE) {
        T oldValue = value;
        value      = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
}
