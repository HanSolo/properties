## Properties
A Java library containing JavaFX like properties but without the bindings and
without the dependencies on the JavaFX packages.

Sometimes it can be very useful to have JavaFX like properties in environments
where you don't have JavaFX available (e.g. Android).

And because even in JavaFX bindings are available I usually don't use them but use
listeners instead for me this is the easiest way of using properties without having
JavaFX available. 

With minor modifications they should also run on Android.

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
```
DoubleProperty value = new DoubleProperty(5);

value.addListener(e -> System.out.println("Value changed from: " + 
                                           e.getOldValue() + 
                                           " to " + 
                                           e.getValue()));
                                           
value.set(7);


#> Value changed from: 5.0 to 7.0
```

## Demo usage
```Java
public class PoJo {
    private DoubleProperty  doubleValue;
    private BooleanProperty booleanValue;

    // ******************** Constructors **************************************
    public PoJo() {
        doubleValue  = new DoubleProperty();
        booleanValue = new BooleanProperty();
    }


    // ******************** Methods *******************************************
    public double getDoubleValue() { return doubleValue.get(); }
    public void setDoubleValue(final double VALUE) { doubleValue.set(VALUE); }
    public DoubleProperty doubleValueProperty() { return doubleValue; }

    public boolean isBooleanValue() { return booleanValue.get(); }
    public ReadOnlyBooleanProperty booleanValueProperty() {
        return booleanValue;
    }
}
```
