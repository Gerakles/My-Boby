package JavaRush.patern;

interface Command {
    void execute();
}

class Carssssss {
    public void startEngine() {
        System.out.println( "запустить двигатель" );
    }

    public void stopEngine() {
        System.out.println( "остановить двигатель" );
    }
}

class StartCar implements Command {
    Carssssss car;

    public StartCar(Carssssss car) {
        this.car = car;
    }

    public void execute() {
        car.startEngine();
    }
}

class StopCar implements Command {
    Carssssss car;

    public StopCar(Carssssss car) {
        this.car = car;
    }

    public void execute() {
        car.stopEngine();
    }
}

class CarInvoker {
    public Command command;

    public CarInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}

public class CommandTest {//тест

    public static void main(String[] args) {
        Carssssss car = new Carssssss();
        StartCar startCar = new StartCar( car );
        StopCar stopCar = new StopCar( car );
        CarInvoker carInvoker = new CarInvoker( startCar );
        carInvoker.execute();
    }
}