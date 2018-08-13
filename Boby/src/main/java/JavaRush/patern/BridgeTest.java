package JavaRush.patern;

interface Enginess {
    void setEngine();
}

abstract class Carsss {
    protected Enginess engine;

    public Carsss(Enginess engine) {
        this.engine = engine;
    }

    abstract public void setEngine();
}

class SportCars extends Carsss {
    public SportCars(Enginess engine) {
        super( engine );
    }

    public void setEngine() {
        System.out.print( "SportCar engine: " );
        engine.setEngine();
    }
}

class UnknownCars extends Carsss {
    public UnknownCars(Enginess engine) {
        super( engine );
    }

    public void setEngine() {
        System.out.print( "UnknownCar engine: " );
        engine.setEngine();
    }
}

class SportEngine implements Enginess {
    public void setEngine() {
        System.out.println( "sport" );
    }
}

class UnknownEngine implements Enginess {
    public void setEngine() {
        System.out.println( "unknown" );
    }
}

public class BridgeTest {//тест

    public static void main(String[] args) {
        Carsss sportCar = new SportCars( new SportEngine() );
        sportCar.setEngine();
        System.out.println();
        Carsss unknownCar = new UnknownCars( new UnknownEngine() );
        unknownCar.setEngine();
    }
}