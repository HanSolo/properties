package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyBooleanProperty extends ReadOnlyProperty<Boolean> {

    // ******************** Constructors **************************************
    public ReadOnlyBooleanProperty() {
        super(null, null, false);
    }
    public ReadOnlyBooleanProperty(final boolean VALUE) {
        super(null, null, Boolean.valueOf(VALUE));
    }
    public ReadOnlyBooleanProperty(final Object BEAN, final String NAME, final boolean VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public boolean get() { return value; }
}
