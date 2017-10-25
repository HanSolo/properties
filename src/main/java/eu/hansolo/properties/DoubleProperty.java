package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class DoubleProperty extends ReadOnlyDoubleProperty {

    // ******************** Constructors **************************************
    public DoubleProperty() {
        super(null, null, 0d);
    }
    public DoubleProperty(final double VALUE) {
        super(null, null, VALUE);
    }
    public DoubleProperty(final Object BEAN, final String NAME, final double VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Double VALUE) {
        double oldValue = value;
        value           = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final double VALUE) { setValue(VALUE); }
}
