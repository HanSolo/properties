package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class StringProperty extends ReadOnlyStringProperty {

    // ******************** Constructors **************************************
    public StringProperty() {
        super(null, null, "");
    }
    public StringProperty(final String VALUE) {
        super(null, null, VALUE);
    }
    public StringProperty(final Object BEAN, final String NAME, final String VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final String VALUE) {
        String oldValue = value;
        value           = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final String VALUE) { setValue(VALUE); }
}
