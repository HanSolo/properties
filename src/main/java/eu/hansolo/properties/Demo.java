package eu.hansolo.properties;

import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

import java.awt.geom.Point2D;


/**
 * User: hansolo
 * Date: 24.10.17
 * Time: 13:30
 */
public class Demo extends Application {
    private PoJo                   pojo;
    private DoubleProperty         doubleProperty;
    private ObjectProperty<String> objectProperty;
    private ObjectProperty<Color>  colorObjectProperty;
    private IntegerProperty        integerProperty;
    private DoubleProperty         doubleProperty1;


    @Override public void init() {
        pojo = new PoJo();

        doubleProperty = new DoubleProperty();
        doubleProperty.addListener(e -> System.out.println(e.getOldValue() + " -> " + e.getValue()));

        objectProperty = new ObjectProperty();
        objectProperty.set(new String("Hallo"));
        objectProperty.addListener(e -> System.out.println(e.getOldValue() + " -> " + e.getValue()));

        colorObjectProperty = new ObjectProperty<Color>(Color.RED) {
            @Override protected void invalidated() { System.out.println("Color changed to: " + get()); }
            @Override public Object getBean() { return Demo.this; }
            @Override public String getName() { return "color"; }
        };
        colorObjectProperty.addListener(e -> System.out.println("Color property changed"));

        integerProperty = new IntegerProperty(10) {
            @Override public void set(final int VALUE) { super.set(VALUE); }
            @Override public int get() { return super.get(); }
            @Override protected void invalidated() { System.out.println("Color changed to: " + get()); }
            @Override public Object getBean() { return Demo.this; }
            @Override public String getName() { return "color"; }
        };

        doubleProperty1 = new DoubleProperty(Demo.this, "oldValue", 10);

    }

    @Override public void start(Stage stage) {
        StackPane pane = new StackPane();

        Scene scene = new Scene(pane);

        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();

        doubleProperty.set(20);

        objectProperty.set(new String("Test"));

        colorObjectProperty.setValue(Color.BLUE);
    }

    @Override public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
