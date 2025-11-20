package gui;

import javax.swing.*;
import service.*;
import model.*;
import java.util.*;

public class BookingGUI extends JFrame {

    public BookingGUI() {
        setTitle("Book Vehicle");
        setSize(350, 400);
        setLayout(null);

        JLabel l1 = new JLabel("Vehicle ID:");
        JLabel l2 = new JLabel("Customer Name:");
        JLabel l3 = new JLabel("Hours:");
        JLabel l4 = new JLabel("Payment Mode:");

        JTextField vidF = new JTextField();
        JTextField nameF = new JTextField();
        JTextField hoursF = new JTextField();

        String[] payModes = {"Cash", "Online"};
        JComboBox<String> payBox = new JComboBox<>(payModes);

        JButton bookBtn = new JButton("Book & Pay");

        l1.setBounds(30, 40, 120, 20);
        l2.setBounds(30, 80, 120, 20);
        l3.setBounds(30, 120, 120, 20);
        l4.setBounds(30, 160, 120, 20);

        vidF.setBounds(150, 40, 120, 20);
        nameF.setBounds(150, 80, 120, 20);
        hoursF.setBounds(150, 120, 120, 20);
        payBox.setBounds(150, 160, 120, 20);

        bookBtn.setBounds(100, 220, 150, 30);

        add(l1); add(l2); add(l3); add(l4);
        add(vidF); add(nameF); add(hoursF);
        add(payBox); add(bookBtn);

        VehicleService vs = new VehicleService();
        BookingService bs = new BookingService();

        bookBtn.addActionListener(e -> {
            List<Vehicle> vehicles = vs.loadVehicles();
            String vid = vidF.getText();
            Vehicle selected = null;

            for (Vehicle v : vehicles)
                if (v.getId().equals(vid) && v.isAvailable())
                    selected = v;

            if (selected == null) {
                JOptionPane.showMessageDialog(null, "Vehicle not available");
                return;
            }

            String name = nameF.getText();
            int hrs = Integer.parseInt(hoursF.getText());
            double total = hrs * selected.getPricePerHour();

            // -------------------------------
            // PAYMENT PROCESSOR (DIP + ISP)
            // -------------------------------
            PaymentProcessor pp;

            if (payBox.getSelectedItem().equals("Cash"))
                pp = new CashPayment();
            else
                pp = new OnlinePayment();

            boolean paid = pp.pay(total);

            if (!paid) {
                JOptionPane.showMessageDialog(null, "Payment Failed!");
                return;
            }

            Booking b = new Booking(
                    "B" + System.currentTimeMillis(),
                    vid,
                    name,
                    hrs,
                    total
            );

            bs.createBooking(b);
            vs.updateAvailability(vid, false);

            JOptionPane.showMessageDialog(null, "Booking Completed Successfully!");
        });

        setVisible(true);
    }
}
