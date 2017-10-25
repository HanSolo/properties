package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ReadOnlyObjectProperty<T> extends ReadOnlyProperty<T> {

    // ******************** Constructors **************************************
    public ReadOnlyObjectProperty() {
        super(null, null, null);
    }
    public ReadOnlyObjectProperty(final T VALUE) {
        super(null, null, VALUE);
    }
    public ReadOnlyObjectProperty(final Object BEAN, final String NAME, final T VALUE) {
        super(BEAN, NAME, VALUE);
    }


    // ******************** Methods *******************************************
    public T get() { return value; }
}
