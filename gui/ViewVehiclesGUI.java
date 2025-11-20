package gui;

import javax.swing.*;
import service.VehicleService;
import model.Vehicle;
import java.util.*;

public class ViewVehiclesGUI extends JFrame {

    public ViewVehiclesGUI() {
        setTitle("View Vehicles");
        setSize(400, 400);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area));

        VehicleService vs = new VehicleService();
        List<Vehicle> list = vs.loadVehicles();

        for (Vehicle v : list)
            area.append(v.toString() + "\n");

        setVisible(true);
    }
}
