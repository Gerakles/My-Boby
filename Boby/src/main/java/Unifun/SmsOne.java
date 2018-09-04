package Unifun;

import Unifun.Library.Smsc;

public class SmsOne {

    public static void main(String[] args) {

        Smsc smsc = new Smsc();

        String [] ret = smsc.send_sms("+37379839605", "Hello", 1, "", "", 0, "", "");
        String balance = smsc.get_balance();

        System.out.println(balance);
    }
}