package JavaRush.patern;

interface Engine {
    String getEngineType();
}

class Car {
    public void buildBase() {
        print( "Делаем корпус" );
    }

    public void buildWheels() {
        print( "Ставим колесо" );
    }

    public void buildEngine(Engine engine) {
        print( "Ставим движок: " + engine.getEngineType() );
    }

    private void print(String msg) {
        System.out.println( msg );
    }
}

class OneEngine implements Engine {
    public String getEngineType() {
        return "Первый двигатель";
    }
}

class TwoEngine implements Engine {
    public String getEngineType() {
        return "Второй двигатель";
    }
}

abstract class Builder {
    protected Car car;

    public abstract Car buildCar();
}

class OneBuilderImpl extends Builder {
    public OneBuilderImpl() {
        car = new Car();
    }

    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine( engine );
        return car;
    }
}

class TwoBuilderImpl extends Builder {
    public TwoBuilderImpl() {
        car = new Car();
    }

    public Car buildCar() {
        car.buildBase();
        car.buildWheels();
        Engine engine = new OneEngine();
        car.buildEngine( engine );
        car.buildWheels();
        engine = new TwoEngine();
        car.buildEngine( engine );
        return car;
    }
}

class Build {
    private Builder builder;

    public Build(int i) {
        if (i == 1) {
            builder = new OneBuilderImpl();
        } else if (i == 2) {
            builder = new TwoBuilderImpl();
        }
    }

    public Car buildCar() {
        return builder.buildCar();
    }
}

public class BuilderTest {//тест

    public static void main(String[] args) {
        Build build = new Build( 1 );
        build.buildCar();
    }
}