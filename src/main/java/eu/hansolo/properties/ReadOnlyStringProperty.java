package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyStringProperty extends ReadOnlyProperty<String> {

    // ******************** Constructors **************************************
    public ReadOnlyStringProperty() {
        super(null, null, "");
    }
    public ReadOnlyStringProperty(final String VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyStringProperty(final Object BEAN, final String NAME, final String VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public String get() { return value; }
}
