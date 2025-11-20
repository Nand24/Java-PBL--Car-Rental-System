package gui;

import javax.swing.*;
import model.*;
import service.VehicleService;

public class AddVehicleGUI extends JFrame {

    public AddVehicleGUI() {
        setTitle("Add Vehicle");
        setSize(420, 420);
        setLayout(null);

        JLabel lBrand = new JLabel("Brand:");
        JLabel lModel = new JLabel("Model:");
        JLabel lPrice = new JLabel("Price/Hr:");
        JLabel lType = new JLabel("Type:");

        JTextField brandF = new JTextField();
        JTextField modelF = new JTextField();
        JTextField priceF = new JTextField();

        String[] types = {"Car", "Bike", "ElectricBike", "LuxuryCar"};
        JComboBox<String> typeBox = new JComboBox<>(types);

        // EXTRA FIELDS
        JLabel extra1 = new JLabel("Battery Range (km):");
        JTextField extraField1 = new JTextField();

        JLabel extra2 = new JLabel("Luxury Tax/Hr:");
        JTextField extraField2 = new JTextField();

        // Initially hidden
        extra1.setVisible(false);
        extraField1.setVisible(false);
        extra2.setVisible(false);
        extraField2.setVisible(false);

        JButton addBtn = new JButton("Add Vehicle");

        lBrand.setBounds(30, 40, 150, 20);
        lModel.setBounds(30, 80, 150, 20);
        lPrice.setBounds(30, 120, 150, 20);
        lType.setBounds(30, 160, 150, 20);

        brandF.setBounds(180, 40, 150, 22);
        modelF.setBounds(180, 80, 150, 22);
        priceF.setBounds(180, 120, 150, 22);
        typeBox.setBounds(180, 160, 150, 22);

        extra1.setBounds(30, 200, 150, 20);
        extraField1.setBounds(180, 200, 150, 22);

        extra2.setBounds(30, 240, 150, 20);
        extraField2.setBounds(180, 240, 150, 22);

        addBtn.setBounds(140, 300, 150, 30);

        add(lBrand); add(lModel); add(lPrice); add(lType);
        add(brandF); add(modelF); add(priceF);
        add(typeBox);
        add(extra1); add(extraField1);
        add(extra2); add(extraField2);
        add(addBtn);

        VehicleService vs = new VehicleService();

        // Show / hide extra fields when type changes
        typeBox.addActionListener(e -> {
            String selected = (String) typeBox.getSelectedItem();

            extra1.setVisible(false);
            extraField1.setVisible(false);
            extra2.setVisible(false);
            extraField2.setVisible(false);

            if (selected.equals("ElectricBike")) {
                extra1.setVisible(true);
                extraField1.setVisible(true);
            } else if (selected.equals("LuxuryCar")) {
                extra2.setVisible(true);
                extraField2.setVisible(true);
            }
        });

        addBtn.addActionListener(e -> {
            try {
                String type = (String) typeBox.getSelectedItem();
                String id = vs.generateVehicleId(type);

                String brand = brandF.getText();
                String model = modelF.getText();
                double price = Double.parseDouble(priceF.getText());

                Vehicle v;

                if (type.equals("Car")) {
                    v = new Car(id, brand, model, price, true);
                } else if (type.equals("Bike")) {
                    v = new Bike(id, brand, model, price, true);
                } else if (type.equals("ElectricBike")) {
                    int range = Integer.parseInt(extraField1.getText());
                    v = new ElectricBike(id, brand, model, price, true, range);
                } else { // LuxuryCar
                    double tax = Double.parseDouble(extraField2.getText());
                    v = new LuxuryCar(id, brand, model, price, true, tax);
                }

                vs.addVehicle(v);
                JOptionPane.showMessageDialog(null, "Vehicle Added!\nID: " + id);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        });

        setVisible(true);
    }
}
