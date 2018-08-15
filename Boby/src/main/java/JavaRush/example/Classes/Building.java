package JavaRush.example.Classes;

public abstract class Building {
    private String name, address, type;

    public static void main(String[] args) {
        Building.Shop myShop = new Building.Shop( "Mamaliga", "Stefan cel Mare 7" );
    }

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Platform extends Building {
        public Platform(String name, String address) {
            super( name, address );
            setType( "Platform" );
        }
    }
     public static class House extends Building {
         public House(String name, String address) {
             super( name, address );
             setType( "House" );
         }
     }

     public static class Shop extends Building {
         public Shop(String name, String address) {
             super( name, address );
             setType( "Shop" );
         }
     }
}
