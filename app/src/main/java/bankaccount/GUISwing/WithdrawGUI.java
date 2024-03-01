package bankaccount.GUISwing;

import java.awt.*;
import javax.swing.*;

public class WithdrawGUI {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420);
    frame.add(withdraw("2500"));
    frame.setVisible(true);
  }

  public static JPanel withdraw(String amount) {
    JPanel panel = new JPanel();
    JLabel secondPageLabel = new JLabel("Account Balance: R" + amount);
    JButton button1 = new JButton();
    JTextField textField = new JTextField();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    secondPageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    secondPageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    button1.setText("Enter");
    textField.setText("0.00");
    Dimension d = null;
    

    d = textField.getPreferredSize();
    d.height = 35;
    d.width = 150;
    textField.setMaximumSize(d);
    button1.setAlignmentX(Component.CENTER_ALIGNMENT);

    panel.add(ImageDisplay.showImage());
    panel.add(secondPageLabel);
    panel.add(textField);
    panel.add(button1);

    return panel;
  }
}
