package service;

import javax.swing.*;

public class CashPayment implements PaymentProcessor {

    @Override
    public boolean pay(double amount) {
        JOptionPane.showMessageDialog(null, 
            "Please collect ₹" + amount + " in cash.\nPayment Successful.");
        return true;
    }
}
