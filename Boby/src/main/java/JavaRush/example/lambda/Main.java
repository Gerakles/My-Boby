package JavaRush.example.lambda;

public class Main {
    public static void main(String[] args) {
        Runnable runnable =() -> staticMethod();
        new Thread( runnable).start();
    }
    private static void staticMethod() {
        System.out.println("Method static");
    }
}
