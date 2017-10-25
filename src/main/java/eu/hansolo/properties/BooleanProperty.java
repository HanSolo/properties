package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class BooleanProperty extends ReadOnlyBooleanProperty {

    // ******************** Constructors **************************************
    public BooleanProperty() {
        super(null, null, false);
    }
    public BooleanProperty(final boolean VALUE) {
        super(null, null, Boolean.valueOf(VALUE));
    }
    public BooleanProperty(final Object BEAN, final String NAME, final boolean VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Boolean VALUE) {
        boolean oldValue = value;
        value      = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final boolean VALUE) { setValue(VALUE); }
}
