package service;

import javax.swing.*;

public class OnlinePayment implements PaymentProcessor {

    @Override
    public boolean pay(double amount) {
        JOptionPane.showMessageDialog(null,
            "Processing Online Payment of ₹" + amount + "...\nPayment Successful!");
        return true;
    }
}
