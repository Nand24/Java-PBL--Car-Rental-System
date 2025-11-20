package model;

public class ElectricBike extends Vehicle {

    private int batteryRange;    // in km

    public ElectricBike(String id, String brand, String model, double pricePerHour, boolean isAvailable, int batteryRange) {
        super(id, brand, model, pricePerHour, isAvailable);
        this.batteryRange = batteryRange;
    }

    public int getBatteryRange() {
        return batteryRange;
    }

    @Override
    public String getType() {
        return "ElectricBike";
    }

    @Override
    public String toString() {
        return getType() + "," + id + "," + brand + "," + model + "," + pricePerHour + "," + isAvailable + "," + batteryRange;
    }
}
