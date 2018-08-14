package JavaRush.example.phone;

public class ThomasEdisonPhone extends AbstractPhone {
    public ThomasEdisonPhone(int year) {
        super( year );
    }

    @Override
    public void call(int outputnumber) {
        System.out.println( "rotate the knob" );
        System.out.println( "Inform the number ot the subscribe, Sir" );
    }

    @Override
    public void ring(int inputnumber) {
        System.out.println( "Phone calls" );
    }

}