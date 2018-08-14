package JavaRush.example.phone;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void callAnotherUser(int namber, AbstractPhone phone) {
        phone.call( namber );
    }
}