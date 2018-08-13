package JavaRush.patern;

interface Visitor {
    void visit(SportCarsss sportCar);
    void visit(Enginesss engine);
    void visit(Whell whell);
}
interface Carsssssss {
    void accept(Visitor visitor);
}
class Enginesss implements Carsssssss {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class Whell implements Carsssssss {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class SportCarsss implements Carsssssss {
    Carsssssss[] cars;
    public SportCarsss(){
        cars = new Carsssssss[]{new Enginesss(), new Whell()};
    }
    public void accept(Visitor visitor) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
class CarVisitor implements Visitor {
    public void visit(SportCarsss computer) {
        print("car");
    }
    public void visit(Enginesss engine) {
        print("engine");
    }
    public void visit(Whell whell) {
        print("whell");
    }
    private void print(String string) {
        System.out.println(string);
    }
}

public class VisitorTest {//тест
    public static void main(String[] args) {
        Carsssssss computer = new SportCarsss();
        computer.accept(new CarVisitor());
    }
}