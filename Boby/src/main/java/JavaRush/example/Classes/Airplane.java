package JavaRush.example.Classes;

public class Airplane {
    private String name, id, flight;
    private Wing leftWing = new Wing("Red", "y3"), rightWing = new Wing("Blue", "y3");

    public Airplane(String name, String id, String flight) {
        this.name = name;
        this.id = id;
        this.flight = flight;
    }

    private class Wing {
        private String color, model;

        public Wing(String color, String model) {
            this.color = color;
            this.model = model;
        }
    }
}
