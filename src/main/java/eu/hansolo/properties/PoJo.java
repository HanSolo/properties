package eu.hansolo.properties;

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
