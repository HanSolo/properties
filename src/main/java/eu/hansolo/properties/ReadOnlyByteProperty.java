package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyByteProperty extends ReadOnlyProperty<Byte> {

    // ******************** Constructors **************************************
    public ReadOnlyByteProperty() {
        super(null, null, (byte) 0);
    }
    public ReadOnlyByteProperty(final byte VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyByteProperty(final Object BEAN, final String NAME, final byte VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public byte get() { return value; }
}
