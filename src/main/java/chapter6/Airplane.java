package chapter6;

public class Airplane {
    private String name, id, flight;
    private Wing leftWing = new Wing("Red", "X3"), rightWing = new Wing("Blue", "X3");


    public Airplane(String name, String id, String flight) {
        this.name = name;
        this.id = id;
        this.flight = flight;
    }

    private class Wing {
        private String color, model;

        private Wing(String color, String model) {
            this.color = color;
            this.model = model;
        }
    }
}
