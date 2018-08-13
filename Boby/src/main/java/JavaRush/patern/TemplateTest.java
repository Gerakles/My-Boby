package JavaRush.patern;

abstract class Carsssss {
    abstract void startEngine();
    abstract void stopEngine();

    public final void start(){
        startEngine();
        stopEngine();
    }
}
class OneCar extends Carsssss {
    public void startEngine() {
        System.out.println("Start engine.");
    }
    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}
class TwoCar extends Carsssss {
    public void startEngine() {
        System.out.println("Start engine.");
    }
    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}

public class TemplateTest {//тест
    public static void main(String[] args) {
        Carsssss car1 = new OneCar();
        car1.start();
        System.out.println();
        Carsssss car2 = new TwoCar();
        car2.start();
    }
}