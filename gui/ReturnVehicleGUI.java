package gui;

import javax.swing.*;
import service.VehicleService;

public class ReturnVehicleGUI extends JFrame {

    public ReturnVehicleGUI() {
        setTitle("Return Vehicle");
        setSize(300, 200);
        setLayout(null);

        JLabel l1 = new JLabel("Enter Vehicle ID:");
        JTextField idField = new JTextField();
        JButton returnBtn = new JButton("Free Vehicle");

        l1.setBounds(30, 40, 150, 20);
        idField.setBounds(150, 40, 100, 20);
        returnBtn.setBounds(80, 90, 120, 30);

        add(l1); add(idField); add(returnBtn);

        VehicleService vs = new VehicleService();

        returnBtn.addActionListener(e -> {
            String vid = idField.getText();

            boolean updated = vs.freeVehicle(vid);

            if (updated)
                JOptionPane.showMessageDialog(null, "Vehicle marked as AVAILABLE.");
            else
                JOptionPane.showMessageDialog(null, "Vehicle ID not found.");
        });

        setVisible(true);
    }
}
