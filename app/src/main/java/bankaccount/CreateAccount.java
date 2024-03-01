package bankaccount;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class CreateAccount {

  String[] informationNeeded = {
    "Name",
    "Surname",
    "Email",
    "ID Number",
    "Cell Number",
  };
  String[] accountType = { "Cheque", "Savings" };

  public void getIdEmailAndName() {
    Scanner sc = new Scanner(System.in);
    String[] arrData = new String[8];
    for (int i = 0; i < informationNeeded.length; i++) {
      System.out.println(informationNeeded[i]);
      String val = sc.nextLine();
      arrData[i] = val;
    }
    for (int i = 0; i < accountType.length; i++) {
      System.out.println(i + 1 + ". " + accountType[i]);
    }
    String val = sc.nextLine();
    System.out.println("please create a 5 digit pin.");
    String code = sc.nextLine();
    System.out.println("please confirm code.");
    String confirmCode = sc.nextLine();
    while(!confirmCode.equals(code)){
      System.out.println("incorrect please ensure that the confirmation code matches the code. " + code);
      confirmCode = sc.nextLine();

    }
    System.out.println("Validating details, please wait...");
    arrData[5] = accountType[Integer.parseInt(val) - 1];
    arrData[6] = "0.00";

    try {
      arrData[7] = HashCode.hashString(code);
      User userInfor = new User(
        arrData[0],
        arrData[1],
        arrData[2],
        arrData[3],
        arrData[4],
        arrData[5],
        arrData[6],
        arrData[7]
      );
      Formatter writeFile = new Formatter(arrData[3] + ".json");
      writeFile.format("%s", userInfor.createJsonObject());

      System.out.println("Account created successfully.");
      writeFile.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    Main.userScreenInput();
    sc.close();
  }

  // public static void main(String[] args) {
  //   CreateAccount obj = new CreateAccount();
  //   obj.getIdEmailAndName();
  // }
}
