package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class CharProperty extends ReadOnlyCharProperty {

    // ******************** Constructors **************************************
    public CharProperty() {
        super(null, null, ' ');
    }
    public CharProperty(final char VALUE) {
        super(null, null, VALUE);
    }
    public CharProperty(final Object BEAN, final String NAME, final char VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    protected void setValue(final Character VALUE) {
        char oldValue = value;
        value         = VALUE;
        invalidated();
        fireEvent(new ChangeEvent<>(this, oldValue, value));
    }
    public void set(final char VALUE) { setValue(VALUE); }
}
