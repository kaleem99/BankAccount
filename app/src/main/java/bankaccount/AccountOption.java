package bankaccount;

import java.util.Scanner;

public class AccountOption {

  public void displayAccountOption() {
    String[] options = { "Deposit", "Withdraw" };
    Scanner sc = new Scanner(System.in);
    System.out.println("Please select an option");
    for (int i = 0; i < options.length; i++) {
      System.out.println(i + 1 + " " + options[i]);
    }
    String choseOpt = sc.nextLine();
    while (!choseOpt.equals("1") && !choseOpt.equals("2")) {
      System.out.println("Please enter a valid option");
      choseOpt = sc.nextLine();
    }
    int selectedOpt = Integer.parseInt(choseOpt) - 1;

    switch (choseOpt) {
      case "1":
        System.out.println(options[selectedOpt]);
        break;
      case "2":
        System.out.println(options[selectedOpt]);

        break;
      default:
        break;
    }
    sc.close();
  }

  public static void main(String[] args) {
    // AccountOption acc = new AccountOption();
    // acc.displayAccountOption();
  }
}
