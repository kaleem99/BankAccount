package bankaccount;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Scanner;

public class AccessAccount {

  static String[] options = { "Withdraw", "Deposit" };
  static String textMessage = "";
  public String convertAndGetJsonData(String key, JsonObject json) {
    String result = json.get(key).getAsString();
    return result;
  }

  public void getAccountDetails(String idNumber) {
    ReadAccountData readAccount = new ReadAccountData();
    AccessAccount myAccount = new AccessAccount();
    Scanner sc = new Scanner(System.in);
    File file = new File(idNumber + ".json");
    if (file.exists()) {
      textMessage = "Please enter your Account pin.";
      System.out.println(textMessage);
      String code = sc.nextLine();
      try {
        Scanner fileSc = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();
        while (fileSc.hasNextLine()) {
          fileContent.append(fileSc.nextLine());
        }
        // Gson gson = new Gson();
        // JsonParser parser = new JsonParser();
        // JsonObject json = parser
        //   .parse(fileContent.toString())
        //   .getAsJsonObject();
        JsonObject json = (JsonObject) readAccount.getJsonObjectData(idNumber);

        String hashStr = myAccount.convertAndGetJsonData("code", json);
        // System.out.println(code);
        boolean result = HashCode.verifyHash(code, hashStr);
        while (!result) {
          System.out.println("Please try again");
          code = sc.nextLine();
          result = HashCode.verifyHash(code, hashStr);
        }
        String accountBalance = myAccount.convertAndGetJsonData("Amount", json);

        double accountValue = Double.parseDouble(accountBalance);
        System.out.println(
          "Your balance is: " +
          accountValue +
          ".\nPlease select an option below"
        );
        for (int i = 0; i < options.length; i++) {
          System.out.println(i + 1 + ". " + options[i]);
        }
        int val = sc.nextInt();

        switch (val) {
          case 1:
            Withdraw.withdrawAmount(accountValue, idNumber);
          case 2:
            Deposit.depositAmount(idNumber);
            break;
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    } else {
      System.out.println("file doesn't exist");
    }
    sc.close();
  }

  public static void main(String[] args) {
    // AccessAccount myObj = new AccessAccount();
    // myObj.getAccountDetails("9908195163089");
  }
}
