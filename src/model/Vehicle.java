package model;

public abstract class Vehicle {
    protected String id;
    protected String brand;
    protected String model;
    protected double pricePerHour;
    protected boolean isAvailable;

    public Vehicle(String id, String brand, String model, double pricePerHour, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerHour = pricePerHour;
        this.isAvailable = isAvailable;
    }

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerHour() { return pricePerHour; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + "," + id + "," + brand + "," + model + "," + pricePerHour + "," + isAvailable;
    }
}
