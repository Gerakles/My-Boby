package JavaRush.example.phone;

public class Phone extends AbstractPhone {
    public Phone(int year) {
        super( year );
    }

    @Override
    public void call(int outputnumber) {
        System.out.println( "call number " + outputnumber );
    }

    @Override
    public void ring(int inputnumber) {
        System.out.println( "Phone calls" );
    }
}