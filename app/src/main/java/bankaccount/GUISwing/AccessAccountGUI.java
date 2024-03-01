package bankaccount.GUISwing;

import bankaccount.AccessAccount;
import bankaccount.ReadAccountData;
import bankaccount.VerifyPin;

import static bankaccount.GUISwing.MainGUI.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.google.gson.JsonObject;

public class AccessAccountGUI extends MainGUI {

  
  public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setSize(420, 420);
    frame.add(AccountOptions());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  static JPanel AccountOptions() {
    // Create a panel for the second page
    JPanel panel = new JPanel();
    VerifyPin verify = new VerifyPin();
    ReadAccountData readAccount = new ReadAccountData();

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel secondPageLabel = new JLabel("Please Enter your ID Number below.");
    secondPageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    secondPageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
    JButton button = new JButton();
    JButton button2 = new JButton();
    JTextField textField = new JTextField();
    JTextField textField2 = new JTextField();
    // textField.setSize(new Dimension(100, 20));
    // textField.setPreferredSize(new Dimension(200, 40));
    System.out.println(textField.getPreferredSize());
    Dimension d = null;
    textField2.setVisible(true);
    d = textField.getPreferredSize();
    d.height = 35;
    d.width = 150;
    button.setText("Previous Page");
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    button2.setText("Continue");
    button2.setAlignmentX(Component.CENTER_ALIGNMENT);
    textField.setMaximumSize(d);
    textField2.setMaximumSize(d);

    // Implement the ActionListener
    button.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          AccessAccountGUI.cardLayout.show(cardPanel, "FirstPage"); // Switch to the FirstPage
        }
      }
    );
    panel.add(ImageDisplay.showImage());
    panel.add(secondPageLabel);

    panel.add(textField);

    // panel.add(textField2);
    panel.add(button2);

    panel.add(button);
    button2.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.out.println(panel.getComponentCount());
          if(panel.getComponentCount() == 5){
            panel.add(textField2, 3);

            panel.revalidate();
            panel.repaint();
          }else{
            String IdNumber = textField.getText();
            String pin = textField2.getText();

            // System.out.println(panel.getComponentCount() + " 100000");
            try{
              JsonObject defaJsonObject = null;
              Boolean bool = verify.verifyUserPin(IdNumber, pin);
              JsonObject json = bool ? (JsonObject) readAccount.getJsonObjectData(IdNumber) : defaJsonObject;
              String amount = json.get("Amount").getAsString();
              cardPanel.add(
                AccountOptionGUI.accountOption(amount),
                "ThirdPage"
              );
              cardLayout.show(cardPanel, "ThirdPage"); 
            }catch(Exception err){
              System.out.println(err);
            }
          }
           
            
            // AccessAccount account = new AccessAccount();
            // // textMessage
            // account.getAccountDetails(text);
        }
      }
    );
    // button2.addActionListener(
    //   new ActionListener() {
    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //       String text = textField.getText();
    //     //   AccessAccount account = new AccessAccount();
    //     //   textMessage
    //     //   account.getAccountDetails(text);
    //     if(textField2.isVisible() == false){
    //         textField2.setVisible(true);
    //     }
    //       System.out.println(text);
    //     }
    //   }

    // );

    return panel;
  }
}
