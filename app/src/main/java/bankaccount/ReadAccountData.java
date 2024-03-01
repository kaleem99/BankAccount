package bankaccount;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Scanner;
public class ReadAccountData {
    public Object getJsonObjectData(String idString){
        File file = new File(idString + ".json");
        JsonObject result = null;
        try{
            Scanner fileSc = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();
            while (fileSc.hasNextLine()) {
              fileContent.append(fileSc.nextLine());
            }
            // Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject json = parser
              .parse(fileContent.toString())
              .getAsJsonObject();
    
            result = json;
            // String hashStr = myAccount.convertAndGetJsonData("Amount", json);
            // result.addProperty("Amount", "200");
            // ((JsonObject) result).addProperty("Amount", "200");
            fileSc.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    public static void main(String[] args) {
        // ReadAccountData accData = new ReadAccountData();
        // System.out.println(accData.getJsonObjectData("9908195163089"));
    }
}
