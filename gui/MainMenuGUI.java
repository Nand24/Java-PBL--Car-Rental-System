package gui;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuGUI extends JFrame {

    public MainMenuGUI() {
        setTitle("Vehicle Rental System");
        setSize(300, 300);
        setLayout(null);

        JButton addBtn = new JButton("Add Vehicle");
        addBtn.setBounds(70, 50, 150, 30);
        add(addBtn);

        JButton viewBtn = new JButton("View Vehicles");
        viewBtn.setBounds(70, 100, 150, 30);
        add(viewBtn);

        JButton bookBtn = new JButton("Book Vehicle");
        bookBtn.setBounds(70, 150, 150, 30);
        add(bookBtn);
        
        JButton returnBtn = new JButton("Return Vehicle");
        returnBtn.setBounds(70, 200, 150, 30);
        add(returnBtn);



        addBtn.addActionListener(e -> new AddVehicleGUI());
        viewBtn.addActionListener(e -> new ViewVehiclesGUI());
        bookBtn.addActionListener(e -> new BookingGUI());
        returnBtn.addActionListener(e -> new ReturnVehicleGUI());
        setVisible(true);
    }
}
