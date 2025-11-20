package model;

public class Car extends Vehicle {

    public Car(String id, String brand, String model, double pricePerHour, boolean isAvailable) {
        super(id, brand, model, pricePerHour, isAvailable);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
