package JavaRush.example.lambda;

public class Main {
    public static void main(String[] args) {
//        Runnable runnable =() -> staticMethod();
//        new Thread( runnable).start();
        System.out.println( "run program" );
        System.out.println( "after lambda" );
        Runnable runnable = () -> System.out.println( "I am lambda" );
        System.out.println( "post lambda" );
        System.out.println( "move lambda in thread" );
        new Thread( runnable ).start();
    }

    private static void staticMethod() {
        System.out.println( "Method static" );
    }
}