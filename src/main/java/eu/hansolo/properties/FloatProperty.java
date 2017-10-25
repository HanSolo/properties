package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class FloatProperty extends ReadOnlyFloatProperty {

    // ******************** Constructors **************************************
    public FloatProperty() {
        super(null, null, 0f);
    }
    public FloatProperty(final float VALUE) {
        super(null, null, VALUE);
    }
    public FloatProperty(final Object BEAN, final String NAME, final float VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Float VALUE) {
        float oldValue = value;
        value          = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final float VALUE) { setValue(VALUE); }
}
