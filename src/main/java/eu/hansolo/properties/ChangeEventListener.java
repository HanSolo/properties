package eu.hansolo.properties;

/**
 * Created by hansolo on 18.10.15.
 */
@FunctionalInterface
public interface ChangeEventListener<T extends ChangeEvent> {
    void onChangeEvent(final T EVENT);
}
