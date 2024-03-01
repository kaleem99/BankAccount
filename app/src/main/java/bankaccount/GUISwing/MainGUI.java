package bankaccount.GUISwing;

import bankaccount.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUI extends JFrame {

  static CardLayout cardLayout = new CardLayout();
  static JPanel cardPanel = new JPanel(cardLayout);
  static JFrame frame;
  // cardLayout = new CardLayout();
  // cardPanel = new JPanel(cardLayout);
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      frame = new JFrame();

      // Initialize CardLayout and JPanel
     

      // Create and add panels to cardPanel
      cardPanel.add(createFirstPage(), "FirstPage");
      cardPanel.add(AccessAccountGUI.AccountOptions(), "SecondPage");
    

      // Set the layout and add the cardPanel to the frame
      frame.setLayout(new BorderLayout());
      frame.add(cardPanel, BorderLayout.CENTER);

      // Set frame properties
      frame.setSize(420, 420);
      frame.setTitle("Bank Account Title");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }

  static JPanel createFirstPage() {
    // Create a panel to hold the components
    Main mainPage = new Main();
    String[] accountOptions = Main.bankOptions;
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // Create a label for the text
    JLabel textLabel = new JLabel("Welcome to the World Bank");
    textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    textLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    panel.add(ImageDisplay.showImage());
    panel.add(textLabel);
    for (int i = 0; i < accountOptions.length; i++) {
      JButton button = new JButton(accountOptions[i]);
      button.setSize(100, 50);
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      button.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "SecondPage"); // Switch to the SecondPage
          }
        }
      );
      panel.add(button);
    }

    // JButton button1 = new JButton("Access Account");
    // JButton button2 = new JButton("Create Account");
    // button1.setSize(100, 50);
    // button2.setSize(100, 50);

    // button1.setAlignmentX(Component.CENTER_ALIGNMENT);
    // button2.setAlignmentX(Component.CENTER_ALIGNMENT);

    // button1.addActionListener(
    //   new ActionListener() {
    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //       cardLayout.show(cardPanel, "SecondPage"); // Switch to the SecondPage
    //     }
    //   }
    // );

    // Add components to the panel

    // panel.add(button1);
    // panel.add(button2);

    // Add the panel to the cardPanel
    return panel;
  }

  static void createThirdPage() {
    cardLayout.show(cardPanel, "ThirdPage"); // Switc
  }
}
