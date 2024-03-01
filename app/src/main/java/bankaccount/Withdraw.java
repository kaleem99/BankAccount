package bankaccount;

import com.google.gson.JsonObject;
import java.util.Scanner;

public class Withdraw {

  private double balance;

  //   Withdraw(double newBalance) {
  //     balance = newBalance;
  //   }
  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public static void withdrawAmount(double newAmount, String idNumber) {
    Withdraw withdraw = new Withdraw();
    ReadAccountData readAcc = new ReadAccountData();
    WriteAccountData writeData = new WriteAccountData();
    JsonObject jsonObject = (JsonObject) readAcc.getJsonObjectData(idNumber);
    withdraw.setBalance(jsonObject.get("Amount").getAsDouble());
    double balance = withdraw.getBalance();
    // balance += newAmount;
    System.out.println("Please enter amount to withdraw");
    Scanner sc = new Scanner(System.in);
    int val = sc.nextInt();
    int count = 0;
    while (val > balance) {
      if (count == 3) {
        System.out.println("please ensure to deposit funds to your account.");
        break;
      }
      System.out.println(
        "Insufficient amount please enter an amount lower than balance."
      );
      val = sc.nextInt();
      count++;
    }
    if (count < 3) {
      // Main main = new Main();
      writeData.writeJsonObjectData(idNumber, "Amount", String.valueOf(val), "Subtract");
      System.out.println("Your money has been withdrawed successfully.");
      Main.userScreenInput();
    }
    sc.close();
  }

  public static void main(String[] args) {
    // Withdraw withdraw = new Withdraw(0);
    // Withdraw.withdrawAmount(100, "9908195163089");
  }
}
