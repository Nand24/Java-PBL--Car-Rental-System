package service;

import model.*;
import data.FileManager;

import java.io.FileWriter;
import java.util.*;

public class VehicleService {

    // -----------------------------
    // LOAD VEHICLES FROM FILE
    // -----------------------------
    public List<Vehicle> loadVehicles() {

        List<String> lines = FileManager.readFile("vehicles.txt");
        List<Vehicle> vehicles = new ArrayList<>();

        for (String line : lines) {

            String[] p = line.split(",");
            String type = p[0];
            String id = p[1];
            String brand = p[2];
            String model = p[3];
            double price = Double.parseDouble(p[4]);
            boolean available = Boolean.parseBoolean(p[5]);

            switch (type) {

                case "Car":
                    vehicles.add(new Car(id, brand, model, price, available));
                    break;

                case "Bike":
                    vehicles.add(new Bike(id, brand, model, price, available));
                    break;

                case "ElectricBike":
                    int range = Integer.parseInt(p[6]);
                    vehicles.add(new ElectricBike(id, brand, model, price, available, range));
                    break;

                case "LuxuryCar":
                    double tax = Double.parseDouble(p[6]);
                    vehicles.add(new LuxuryCar(id, brand, model, price, available, tax));
                    break;
            }
        }

        return vehicles;
    }

    // -----------------------------
    // ADD VEHICLE
    // -----------------------------
    public void addVehicle(Vehicle v) {
        FileManager.writeFile("vehicles.txt", v.toString());
    }

    // -----------------------------
    // UPDATE AVAILABILITY
    // -----------------------------
    public void updateAvailability(String vehicleId, boolean status) {
        List<Vehicle> list = loadVehicles();
        try {
            FileWriter fw = new FileWriter("database/vehicles.txt", false);
            for (Vehicle v : list) {
                if (v.getId().equals(vehicleId))
                    v.setAvailable(status);

                fw.write(v.toString() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -----------------------------
    // FREE VEHICLE (RETURN)
    // -----------------------------
    public boolean freeVehicle(String vehicleId) {
        List<Vehicle> list = loadVehicles();
        boolean found = false;

        try {
            FileWriter fw = new FileWriter("database/vehicles.txt", false);

            for (Vehicle v : list) {
                if (v.getId().equals(vehicleId)) {
                    v.setAvailable(true);
                    found = true;
                }
                fw.write(v.toString() + "\n");
            }

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }

    // -----------------------------
    // AUTO-GENERATE VEHICLE ID
    // -----------------------------
    public String generateVehicleId(String type) {

        List<Vehicle> vehicles = loadVehicles();
        int max = 0;

        String prefix;
        if (type.equals("Car")) prefix = "CAR";
        else if (type.equals("Bike")) prefix = "BIKE";
        else if (type.equals("ElectricBike")) prefix = "EBIKE";
        else prefix = "LUX";

        for (Vehicle v : vehicles) {
            if (v.getType().equals(type)) {
                try {
                    int num = Integer.parseInt(v.getId().replace(prefix, ""));
                    if (num > max)
                        max = num;
                } catch (Exception ignored) {
                }
            }
        }

        return prefix + (max + 1);
    }
}
