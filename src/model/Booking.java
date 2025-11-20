package model;

public class Booking {
    private String bookingId;
    private String vehicleId;
    private String customerName;
    private int hours;
    private double totalPrice;

    public Booking(String bookingId, String vehicleId, String customerName, int hours, double totalPrice) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.customerName = customerName;
        this.hours = hours;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return bookingId + "," + vehicleId + "," + customerName + "," + hours + "," + totalPrice;
    }
}
