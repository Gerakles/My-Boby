package JavaRush.patern;

interface Carss {
    void start();

    void stop();
}

class Key implements Carss {
    public void start() {
        System.out.println( "Вставить ключи" );
    }

    public void stop() {
        System.out.println( "Вытянуть ключи" );
    }
}

class Engines implements Carss {
    public void start() {
        System.out.println( "Запустить двигатель" );
    }

    public void stop() {
        System.out.println( "Остановить двигатель" );
    }
}

class Facade {
    private Key key;
    private Engines engine;

    public Facade() {
        key = new Key();
        engine = new Engines();
    }

    public void startCar() {
        key.start();
        engine.start();
    }

    public void stoptCar() {
        key.stop();
        engine.stop();
    }
}

public class FacadeTest {//тест

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stoptCar();
    }
}