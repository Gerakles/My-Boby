package JavaRush.example.Classes;

public class Animal {
    public static void main(String[] args) {
        Animal anonTiger = new Animal() {
            @Override
            public void meow() {
                System.out.println( "Rrrrar!" );
            }
        };

        Animal notAnonTiger = new Animal().new Tiger();
        anonTiger.meow();
        notAnonTiger.meow();
    }

    public void meow() {
        System.out.println( "Moew!" );
    }

    private class Tiger extends Animal {

        public void meow() {
            System.out.println( "Rrar!" );
        }
    }
}