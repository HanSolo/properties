package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyCharProperty extends ReadOnlyProperty<Character> {

    // ******************** Constructors **************************************
    public ReadOnlyCharProperty() {
        super(null, null, ' ');
    }
    public ReadOnlyCharProperty(final char VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyCharProperty(final Object BEAN, final String NAME, final char VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public char get() { return value; }
}
