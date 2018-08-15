package JavaRush.example.phone;

public class SomePhone {
    private int year;
    private String company;

    public SomePhone(int year, String company) {
        this.year = year;
        this.company = company;
    }

    private void openConnection() {
    }

    public void call() {
        openConnection();
        System.out.println( "call number" );
    }

    public void ring() {
        System.out.println( "ring ring" );
    }
}