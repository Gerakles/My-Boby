package JavaRush.example.lambda;

import java.util.concurrent.atomic.AtomicInteger;

public class lambda {
    public static void main(String[] args) {
        final AtomicInteger counter = new AtomicInteger( 0 );
        Runnable r = () -> counter.incrementAndGet();
    }
}