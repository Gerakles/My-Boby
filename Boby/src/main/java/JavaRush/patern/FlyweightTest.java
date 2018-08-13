package JavaRush.patern;

class Flyweight {
    private int row;

    public Flyweight(int row) {
        this.row = row;
        System.out.println( "ctor: " + this.row );
    }

    void report(int col) {
        System.out.print( " " + row + col );
    }
}

class Factorys {
    private Flyweight[] pool;

    public Factorys(int maxRows) {
        pool = new Flyweight[maxRows];
    }

    public Flyweight getFlyweight(int row) {
        if (pool[row] == null) {
            pool[row] = new Flyweight( row );
        }
        return pool[row];
    }
}

public class FlyweightTest {//тест

    public static void main(String[] args) {
        int rows = 5;
        Factorys theFactory = new Factorys( rows );
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                theFactory.getFlyweight( i ).report( j );
            }
            System.out.println();
        }
    }
}