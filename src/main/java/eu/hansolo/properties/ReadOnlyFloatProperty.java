package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyFloatProperty extends ReadOnlyProperty<Float> {

    // ******************** Constructors **************************************
    public ReadOnlyFloatProperty() {
        super(null, null, 0f);
    }
    public ReadOnlyFloatProperty(final float VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyFloatProperty(final Object BEAN, final String NAME, final float VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public float get() { return value; }
}
