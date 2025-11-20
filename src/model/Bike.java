package model;

public class Bike extends Vehicle {

    public Bike(String id, String brand, String model, double pricePerHour, boolean isAvailable) {
        super(id, brand, model, pricePerHour, isAvailable);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
