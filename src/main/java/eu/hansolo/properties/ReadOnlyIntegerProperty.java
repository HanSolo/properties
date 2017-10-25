package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyIntegerProperty extends ReadOnlyProperty<Integer> {

    // ******************** Constructors **************************************
    public ReadOnlyIntegerProperty() {
        super(null, null, 0);
    }
    public ReadOnlyIntegerProperty(final int VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyIntegerProperty(final Object BEAN, final String NAME, final int VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public int get() { return value; }
}
