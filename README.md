## Properties
A Java library containing JavaFX like properties but 
without the dependencies on the JavaFX packages.

Sometimes it can be very useful to have JavaFX like properties in environments
where you don't have JavaFX available (e.g. Android).

If you would like to use it on Android just checkout the android branch. This branch
contains the exact same code as the master branch but without using the Java 8 features.

There the following properties available:
- ByteProperty
- ReadOnlyByteProperty
- ShortProperty
- ReadOnlyShortProperty
- LongProperty
- ReadOnlyLongProperty
- IntegerProperty
- ReadOnlyIntegerProperty
- FloatProperty
- ReadOnlyFloatProperty
- DoubleProperty
- ReadOnlyDoubleProperty
- StringProperty
- ReadOnlyStringProperty
- CharProperty
- ReadOnlyCharProperty
- ObjectProperty
- ReadOnlyObjectProperty

On each property you can add remove event listeners as follows:
```Java
// define a change listener
ChangeEventListener doubleChangeEventListener = e -> System.out.println(e.getOldValue() + " -> " + e.getValue());

// define a property
DoubleProperty doubleProperty = new DoubleProperty() {
    @Override protected void willChange(final Double oldValue, final Double newValue) {
        System.out.println("DoubleProperty will change from " + oldValue + " to " + newValue);
    }
    @Override protected void didChange(final Double oldValue, final Double newValue) {
        System.out.println("DoubleProperty changed from " + oldValue + " to " + newValue);
    }
};

// adds given listener
doubleProperty.setOnPropertyChanged(doubleChangeEventListener);

// removes given listener
doubleProperty.removeListener(doubleChangeEventListener);

// removes all listeners
doubleProperty.removeAllListeners();




#> DoubleProperty will change from 0.0 to 20.0
#> 0.0 -> 20.0
#> DoubleProperty changed from 0.0 to 20.0
```
