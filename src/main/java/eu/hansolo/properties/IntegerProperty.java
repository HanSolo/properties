package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class IntegerProperty extends ReadOnlyIntegerProperty {

    // ******************** Constructors **************************************
    public IntegerProperty() {
        super(null, null, 0);
    }
    public IntegerProperty(final int VALUE) {
        super(null, null, VALUE);
    }
    public IntegerProperty(final Object BEAN, final String NAME, final int VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Integer VALUE) {
        int oldValue = value;
        value        = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final int VALUE) { setValue(VALUE); }
}
