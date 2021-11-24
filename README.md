## Properties 

<br>
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
ChangeEventListener doubleChangeListener = e -> System.out.println(e.getOldValue() + " -> " + e.getValue());

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
doubleProperty.setOnPropertyChanged(doubleChangeListener);

// removes given listener
doubleProperty.removeListener(doubleChangeListener);

// removes all listeners
doubleProperty.removeAllListeners();




#> DoubleProperty will change from 0.0 to 20.0
#> 0.0 -> 20.0
#> DoubleProperty changed from 0.0 to 20.0
```

You can also bind properties to other properties. Unidirectional and bidirectional
bindings are supported. 
Here are some examples that you can also find in the Demo.java class.

````java
// Bindings unidirectional
System.out.println("\n\n---------- Unidirectional Binding ------------");
DoubleProperty propertyA = new DoubleProperty(5);
DoubleProperty propertyB = new DoubleProperty(10);

System.out.println("Property A: " + propertyA.get() + " is bound: " + propertyA.isBound());
System.out.println("Property B: " + propertyB.get() + " is bound: " + propertyB.isBound());

System.out.println("\npropertyA.bind(propertyB)");
propertyA.bind(propertyB);

System.out.println("\nProperty A: " + propertyA.get() + " is bound: " + propertyA.isBound());
System.out.println("Property B: " + propertyB.get() + " is bound: " + propertyB.isBound());

System.out.println("\npropertyB.set(5)");
propertyB.set(5);

System.out.println("\npropertyB = " + propertyB.get());
System.out.println("propertyA = " + propertyA.get());

System.out.println("\npropertyA.set(20)");
try {
    propertyA.set(20);
} catch (IllegalArgumentException e) {
    System.out.println("Error, a bound value cannot be set.");
}

System.out.println("\npropertyA.unbind()");
propertyA.unbind();

System.out.println("\nProperty A: " + propertyA.get() + " is bound: " + propertyA.isBound());
System.out.println("Property B: " + propertyB.get() + " is bound: " + propertyB.isBound());

System.out.println("\npropertyB.set(15)");
propertyB.set(15);

System.out.println("\nProperty A: " + propertyA.get() + " is bound: " + propertyA.isBound());
System.out.println("Property B: " + propertyB.get() + " is bound: " + propertyB.isBound());

// Bindings bidirectional
System.out.println("\n\n---------- Bidirectional Binding ------------");
DoubleProperty propertyC = new DoubleProperty(0);
DoubleProperty propertyD = new DoubleProperty(25);

System.out.println("Property C: " + propertyC.get() + " is bound bidirectional: " + propertyC.isBoundBidirectional());
System.out.println("Property D: " + propertyD.get() + " is bound bidirectional: " + propertyD.isBoundBidirectional());
System.out.println("\npropertyC.bindBidirectional(propertyD)");
propertyC.bindBidirectional(propertyD);
System.out.println("\nProperty C: " + propertyC.get() + " is bound bidirectional: " + propertyC.isBoundBidirectional());
System.out.println("Property D: " + propertyD.get() + " is bound bidirectional: " + propertyD.isBoundBidirectional());
System.out.println("\npropertyD.set(5)");
propertyD.set(5);
System.out.println("\npropertyC = " + propertyC.get());
System.out.println("propertyD = " + propertyD.get());
System.out.println("\npropertyC.set(20)");
propertyC.set(20);
System.out.println("\npropertyC = " + propertyC.get());
System.out.println("propertyD = " + propertyD.get());
System.out.println("\npropertyD.unbind()");
propertyD.unbind();
System.out.println("\nProperty C: " + propertyC.get() + " is bound bidirectional: " + propertyC.isBoundBidirectional());
System.out.println("Property D: " + propertyD.get() + " is bound bidirectional: " + propertyD.isBoundBidirectional());
System.out.println("\npropertyD.set(5)");
propertyD.set(5);
System.out.println("\nProperty C: " + propertyC.get() + " is bound bidirectional: " + propertyC.isBoundBidirectional());
System.out.println("Property D: " + propertyD.get() + " is bound bidirectional: " + propertyD.isBoundBidirectional());
System.out.println("\npropertyC.set(10)");
propertyC.set(10);
System.out.println("\nProperty C: " + propertyC.get() + " is bound bidirectional: " + propertyC.isBoundBidirectional());
System.out.println("Property D: " + propertyD.get() + " is bound bidirectional: " + propertyD.isBoundBidirectional());
````

The output on the console of the above code looks like follows...

```
---------- Unidirectional Binding ------------
Property A: 5.0 is bound: false
Property B: 10.0 is bound: false

propertyA.bind(propertyB)

Property A: 10.0 is bound: true
Property B: 10.0 is bound: false

propertyB.set(5)

propertyB = 5.0
propertyA = 5.0

propertyA.set(20)
Error, a bound value cannot be set.

propertyA.unbind()

Property A: 5.0 is bound: false
Property B: 5.0 is bound: false

propertyB.set(15)

Property A: 5.0 is bound: false
Property B: 15.0 is bound: false


---------- Bidirectional Binding ------------
Property C: 0.0 is bound bidirectional: false
Property D: 25.0 is bound bidirectional: false

propertyC.bindBidirectional(propertyD)

Property C: 25.0 is bound bidirectional: true
Property D: 25.0 is bound bidirectional: true

propertyD.set(5)

propertyC = 5.0
propertyD = 5.0

propertyC.set(20)

propertyC = 20.0
propertyD = 20.0

propertyD.unbind()

Property C: 20.0 is bound bidirectional: false
Property D: 20.0 is bound bidirectional: false

propertyD.set(5)

Property C: 20.0 is bound bidirectional: false
Property D: 5.0 is bound bidirectional: false

propertyC.set(10)

Property C: 10.0 is bound bidirectional: false
Property D: 5.0 is bound bidirectional: false

Process finished with exit code 0
```
