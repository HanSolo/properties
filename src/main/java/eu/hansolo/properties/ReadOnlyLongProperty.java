package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyLongProperty extends ReadOnlyProperty<Long> {

    // ******************** Constructors **************************************
    public ReadOnlyLongProperty() {
        super(null, null, 0l);
    }
    public ReadOnlyLongProperty(final long VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyLongProperty(final Object BEAN, final String NAME, final long VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public long get() { return value; }
}
