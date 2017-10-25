package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ByteProperty extends ReadOnlyByteProperty {

    // ******************** Constructors **************************************
    public ByteProperty() {
        super(null, null, (byte) 0);
    }
    public ByteProperty(final byte VALUE) {
        super(null, null, VALUE);
    }
    public ByteProperty(final Object BEAN, final String NAME, final byte VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Byte VALUE) {
        byte oldValue = value;
        value         = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final byte VALUE) { setValue(VALUE); }
}

