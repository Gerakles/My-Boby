package JavaRush.example;

public class Binging {
    public static void main(String[] args) {
        Insurance current = new CarInsurance();

        int premium = current.premium();
        String category = current.category();

        System.out.println( "premium : " + premium );
        System.out.println( "category : " + category );
    }
}

class Insurance {
    public static final int LOW = 100;

    public static String category() {
        return "Insurance";
    }

    public int premium() {
        return LOW;
    }
}

class CarInsurance extends Insurance {
    public static final int HIGH = 200;

    public static String category() {
        return "Car Insurance";
    }

    public int premium() {
        return HIGH;
    }
}