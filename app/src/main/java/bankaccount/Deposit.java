package bankaccount;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class Deposit {

  private int amount;
  static String[] options = { "Proceed", "Cancel" };

  // Deposit(int amount){
  //     this.amount = amount;
  // }
  public static void depositAmount(String idNumber) {
    Scanner sc = new Scanner(System.in);
    System.out.println(
      "Please note that a minum amount of 50 a max of 10,000 can be deposited."
    );
    int val = sc.nextInt();
    while (val < 50 || val > 10000) {
      System.out.println("Please enter a valid amount");
      val = sc.nextInt();
    }
    if (val >= 50 && val <= 10000) {
      for (int i = 0; i < options.length; i++) {
        System.out.println(i + 1 + ". " + options[i]);
      }
    }
    System.out.println("Please select an option");
    sc.nextLine();

    String opt = sc.nextLine();
    while (!opt.equals("1") && !opt.equals("2")) {
      System.out.println("Please enter a valid option");
      opt = sc.nextLine();
    }
    switch (opt) {
      case "1":
        // ReadAccountData accData = new ReadAccountData();

        WriteAccountData writeData = new WriteAccountData();
        writeData.writeJsonObjectData(idNumber, "Amount", String.valueOf(val), "Add");
        // ReadAccountData;
        System.out.println(
          "Amount of " + val + " has been deposited successfully."
        );
        Main.userScreenInput();
        break;
      case "2":
        System.out.println("Thank you.");
        sc.close();
      default:
        break;
    }
  }

  public static void main(String[] args) {
    // Deposit.depositAmount("9908195163089");
  }
}
