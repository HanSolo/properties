package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyDoubleProperty extends ReadOnlyProperty<Double> {

    // ******************** Constructors **************************************
    public ReadOnlyDoubleProperty() {
        super(null, null, 0d);
    }
    public ReadOnlyDoubleProperty(final double VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyDoubleProperty(final Object BEAN, final String NAME, final double VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public double get() { return value; }
}
