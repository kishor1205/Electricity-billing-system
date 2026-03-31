package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Paytm extends JFrame implements ActionListener {

    String meter;
    JButton back;

    Paytm(String meter) {
        this.meter = meter;

        setLayout(null);

        JLabel label = new JLabel("Redirecting to Paytm...");
        label.setBounds(50, 50, 300, 30);
        add(label);

        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        add(back);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);

        // Open default browser
        try {
            Desktop.getDesktop().browse(new URI("https://paytm.com/online-payments"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not open browser.");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new PayBill(meter);
    }

    public static void main(String[] args) {
        new Paytm("");
    }
}
