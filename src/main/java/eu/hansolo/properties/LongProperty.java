package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class LongProperty extends ReadOnlyLongProperty {

    // ******************** Constructors **************************************
    public LongProperty() {
        super(null, null, 0l);
    }
    public LongProperty(final long VALUE) {
        super(null, null, VALUE);
    }
    public LongProperty(final Object BEAN, final String NAME, final long VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Long VALUE) {
        long oldValue = value;
        value         = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final long VALUE) { setValue(VALUE); }
}
