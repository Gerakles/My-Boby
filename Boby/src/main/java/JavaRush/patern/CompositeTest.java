package JavaRush.patern;

import java.util.ArrayList;
import java.util.List;

interface Cars {
    void draw(String color);
}

class SportCar implements Cars {
    public void draw(String color) {
        System.out.println( "SportCar color: " + color );
    }
}

class UnknownCar implements Cars {
    public void draw(String color) {
        System.out.println( "UnknownCar color: " + color );
    }
}

class Drawing implements Cars {
    private List <Cars> cars = new ArrayList <Cars>();

    public void draw(String color) {
        for (Cars car : cars) {
            car.draw( color );
        }
    }

    public void add(Cars s) {
        this.cars.add( s );
    }

    public void clear() {
        System.out.println();
        this.cars.clear();
    }
}

public class CompositeTest {//тест

    public static void main(String[] args) {
        Cars sportCar = new SportCar();
        Cars unknownCar = new UnknownCar();
        Drawing drawing = new Drawing();
        drawing.add( sportCar );
        drawing.add( unknownCar );
        drawing.draw( "green" );
        drawing.clear();
        drawing.add( sportCar );
        drawing.add( unknownCar );
        drawing.draw( "white" );
    }
}