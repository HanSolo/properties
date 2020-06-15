/*
 * Copyright (c) 2017 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.properties;


public class Demo {
    private PoJo                   pojo;
    private DoubleProperty         doubleProperty;
    private ObjectProperty<String> objectProperty;
    private IntegerProperty        integerProperty;
    private DoubleProperty         doubleProperty1;
    private ReadOnlyDoubleProperty readOnlyDoubleProperty;


    public Demo() {
        pojo = new PoJo();

        ChangeListener doubleChangeListener = e -> System.out.println(e.getOldValue() + " -> " + e.getValue());

        // Setup properties
        doubleProperty = new DoubleProperty() {
            @Override protected void willChange(final Double oldValue, final Double newValue) {
                System.out.println("\nDoubleProperty will change from " + oldValue + " to " + newValue + "\n");
            }
            @Override protected void didChange(final Double oldValue, final Double newValue) {
                System.out.println("\nDoubleProperty changed from " + oldValue + " to " + newValue + "\n");
            }
        };

        doubleProperty.setOnPropertyChanged(doubleChangeListener);

        doubleProperty.removeListener(doubleChangeListener);

        doubleProperty.removeAllListeners();


        objectProperty = new ObjectProperty();

        integerProperty = new IntegerProperty(10) {
            @Override public void set(final int VALUE) { super.set(VALUE); }
            @Override public int get() { return super.get(); }
            @Override protected void didChange(final Integer oldValue, final Integer newValue) { System.out.println("Color changed to: " + newValue); }
            @Override public Object getBean() { return Demo.this; }
            @Override public String getName() { return "color"; }
        };

        doubleProperty1 = new DoubleProperty(Demo.this, "oldValue", 10);

        readOnlyDoubleProperty = new ReadOnlyDoubleProperty(5);


        // Register listeners
        pojo.doubleValueProperty().setOnPropertyChanged(e -> System.out.println(e.getOldValue() + " -> " + e.getValue()));

        doubleProperty.addListener(e -> System.out.println(e.getOldValue() + " -> " + e.getValue()));

        objectProperty.addListener(e -> System.out.println(e.getOldValue() + " -> " + e.getValue()));


        // Set values
        pojo.setDoubleValue(7);

        doubleProperty.set(20);

        objectProperty.set(new String("Hallo"));

        objectProperty.set(new String("Test"));

        objectProperty.set("Bla");


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
    }

    public static void main(String[] args) {
        new Demo();
    }



    public class PoJo {
        private DoubleProperty  doubleValue;
        private BooleanProperty booleanValue;

        // ******************** Constructors **************************************
        public PoJo() {
            doubleValue  = new DoubleProperty(3);
            booleanValue = new BooleanProperty(true);
        }


        // ******************** Methods *******************************************
        public double getDoubleValue() { return doubleValue.get(); }
        public void setDoubleValue(final double value) { doubleValue.set(value); }
        public DoubleProperty doubleValueProperty() { return doubleValue; }

        public boolean isBooleanValue() { return booleanValue.get(); }
        public ReadOnlyBooleanProperty booleanValueProperty() {
            return booleanValue;
        }
    }
}
