package JavaRush.example.Classes;

public class Person {
    private String name, street, house;

    public Person(String name, String street, String house) {
        this.name = name;
        this.street = street;
        this.house = house;
    }

    private interface AddressContainer {
        String getStreet();
        String getHouse();
    }
    public AddressContainer getAddressContainer() {
        class PersonAddressContainer implements AddressContainer {
            final String street = Person.this.street, house = Person.this.house;

            @Override
            public String getStreet() {
                return null;
            }

            @Override
            public String getHouse() {
                return null;
            }
        }
        return new PersonAddressContainer();
    }

    public static void main(String[] args) {
        Person person = new Person( "Bpgdan", "Pietrarilor", "14/3" );

        AddressContainer address = person.getAddressContainer();
        System.out.println("Address: street - "+ address.getStreet()+", house - "+address.getHouse());
    }
}
