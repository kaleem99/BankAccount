package bankaccount.GUISwing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageDisplay {

  static JLabel showImage() {
    // JPanel panel = new JPanel();
    // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    java.net.URL imageURL =
      MainGUI.class.getClassLoader().getResource("images/bank.jpeg");
    ImageIcon imageIcon = new ImageIcon(imageURL);
    Image image = imageIcon
      .getImage()
      .getScaledInstance(150, 120, Image.SCALE_SMOOTH);
    ImageIcon scaledImageIcon = new ImageIcon(image);
    JLabel label = new JLabel();
    label.setIcon(scaledImageIcon);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

    return label;
  }
}
