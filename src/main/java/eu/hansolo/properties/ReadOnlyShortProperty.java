package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyShortProperty extends ReadOnlyProperty<Short> {

    // ******************** Constructors **************************************
    public ReadOnlyShortProperty() {
        super(null, null, (short) 0);
    }
    public ReadOnlyShortProperty(final short VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyShortProperty(final Object BEAN, final String NAME, final short VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public short get() { return value; }
}
