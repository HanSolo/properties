package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
public class ChangeEvent<T extends Object> {
    private Object src;
    private T      oldValue;
    private T      value;


    // ******************** Constructors **************************************
    public ChangeEvent(final Object SRC, final T OLD_VALUE, final T VALUE) {
        src      = SRC;
        oldValue = OLD_VALUE;
        value    = VALUE;
    }


    // ******************** Methods *******************************************
    public Object getSource() { return src; }

    public T getOldValue() { return oldValue; }

    public T getValue() { return value; }
}
