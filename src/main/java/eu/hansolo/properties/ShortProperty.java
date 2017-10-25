package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ShortProperty extends ReadOnlyShortProperty {

    // ******************** Constructors **************************************
    public ShortProperty() {
        super(null, null, (short) 0);
    }
    public ShortProperty(final short VALUE) {
        super(null, null, VALUE);
    }
    public ShortProperty(final Object BEAN, final String NAME, final short VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Short VALUE) {
        short oldValue = value;
        value          = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final short VALUE) { setValue(VALUE); }
}
