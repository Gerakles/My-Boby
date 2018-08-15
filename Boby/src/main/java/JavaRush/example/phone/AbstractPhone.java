package JavaRush.example.phone;

public abstract class AbstractPhone {
    private int year;

    public AbstractPhone(int year) {
        this.year = year;
    }

    public abstract void call(int outputnumber);

    public abstract void ring(int inputnumber);
}