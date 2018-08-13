package JavaRush.patern;

interface Carssss {
    void draw();
}

class SportCarss implements Carssss {
    public void draw() {
        System.out.println( "SportCar" );
    }
}

class UnknownCarss implements Carssss {
    public void draw() {
        System.out.println( "UnknownCar" );
    }
}

abstract class CarDecorator implements Carssss {
    protected Carssss decorated;

    public CarDecorator(Carssss decorated) {
        this.decorated = decorated;
    }

    public void draw() {
        decorated.draw();
    }
}

class BlueCarDecorator extends CarDecorator {
    public BlueCarDecorator(Carssss decorated) {
        super( decorated );
    }

    public void draw() {
        decorated.draw();
        setColor();
    }

    private void setColor() {
        System.out.println( "Color: red" );
    }
}

public class DecoratorTest {//тест

    public static void main(String[] args) {
        Carssss sportCar = new SportCarss();
        Carssss blueUnknownCar = new BlueCarDecorator( new UnknownCarss() );
        sportCar.draw();
        System.out.println();
        blueUnknownCar.draw();
    }
}