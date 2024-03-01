package bankaccount.GUISwing;

import java.awt.*;
import javax.swing.*;

import bankaccount.VerifyPin;
public class AccountOptionGUI{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.add(accountOption("2500"));
        frame.setVisible(true);
    }
    public static JPanel accountOption(String amount){

        JPanel panel = new JPanel();
        JLabel secondPageLabel = new JLabel("Account Balance: R" + amount);
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        secondPageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        secondPageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        button1.setText("Withdraw");
        button2.setText("Deposit");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(ImageDisplay.showImage());
        panel.add(secondPageLabel);
        panel.add(button1);
        panel.add(button2);

        return panel;
    }
}