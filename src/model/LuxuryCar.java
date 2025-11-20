package model;

public class LuxuryCar extends Vehicle {

    private double luxuryTax;     // extra charge per hour

    public LuxuryCar(String id, String brand, String model, double pricePerHour,
                     boolean isAvailable, double luxuryTax) {

        super(id, brand, model, pricePerHour, isAvailable);
        this.luxuryTax = luxuryTax;
    }

    public double getLuxuryTax() {
        return luxuryTax;
    }

    @Override
    public String getType() {
        return "LuxuryCar";
    }

    // override price
    @Override
    public double getPricePerHour() {
        return pricePerHour + luxuryTax;
    }

    @Override
    public String toString() {
        return getType() + "," + id + "," + brand + "," + model + "," + pricePerHour + "," + isAvailable + "," + luxuryTax;
    }
}
