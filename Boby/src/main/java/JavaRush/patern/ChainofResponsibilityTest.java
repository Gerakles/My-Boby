package JavaRush.patern;

interface Payment {
    void setNext(Payment payment);

    void pay();
}

class VisaPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println( "Visa Payament" );
    }
}

class PayPalPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println( "PayPal Payament" );
    }
}

public class ChainofResponsibilityTest {//тест

    public static void main(String[] args) {
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext( payPalPayment );
        visaPayment.pay();
    }
}