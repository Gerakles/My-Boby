package JavaRush.example.phone;

public class Phones {
    public static void main(String[] args) {
        AbstractPhone phone = new ThomasEdisonPhone( 1879 );
        AbstractPhone phone2 = new Phone( 1984 );
        AbstractPhone videoPhone = new VideoPhone( 2018 );
        User user = new User( "Bogdan" );
        user.callAnotherUser( 839605, phone );
        user.callAnotherUser( 222811, phone2 );
        user.callAnotherUser( 735805, videoPhone );
    }
}