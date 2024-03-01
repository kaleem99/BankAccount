package bankaccount;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Formatter;

public class WriteAccountData {

  public void writeJsonObjectData(JsonObject jsonObjectData) {
    try {
      String fileName = jsonObjectData.get("idNumber").toString();
      Formatter writeFile = new Formatter(fileName + ".json");
      writeFile.format("%s", jsonObjectData);
      writeFile.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void writeJsonObjectData(
    String IdNumber,
    String key,
    String newData,
    String type
  ) {
    try {
      ReadAccountData readAcc = new ReadAccountData();
      // System.out.println(accData.getJsonObjectData(idNumber));
      // System.out.println(newAmount);
      JsonObject jsonObject = (JsonObject) readAcc.getJsonObjectData(IdNumber);

      // Object accDataJson = readAcc.getJsonObjectData(IdNumber);
      // JsonParser parser = new JsonParser();
      // JsonObject json = parser.parse(accDataJson.toString()).getAsJsonObject();
      // String fileName = jsonObjectData.get("idNumber").getAsString();

      Double initialAmount = jsonObject.getAsJsonObject().get("Amount").getAsDouble();
      String newAmount = "";
      if(type == "Add"){
        newAmount = String.valueOf(initialAmount + Double.parseDouble(newData));
      }else{
        newAmount = String.valueOf(initialAmount - Double.parseDouble(newData));
      }
      jsonObject.addProperty(key, newAmount);

      Formatter writeFile = new Formatter(IdNumber + ".json");
      writeFile.format("%s", jsonObject);
      writeFile.close();
      
    } catch (Exception e) {
      System.err.println(e);
    }
  }
  public static void main(String[] args) {
    // WriteAccountData writeData = new WriteAccountData();
    // writeData.writeJsonObjectData("9908195163089", "Amount", "100", "Subtract");
  }
}
