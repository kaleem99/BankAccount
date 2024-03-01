package bankaccount;

import java.security.NoSuchAlgorithmException;

import com.google.gson.JsonObject;

public class VerifyPin {
    public static void main(String[] args) {
        VerifyPin verify = new VerifyPin();
        try{
            boolean bool = verify.verifyUserPin("9908195163089", "11530");
            System.out.println(bool);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean verifyUserPin(String IdNumber, String code) throws NoSuchAlgorithmException{
        ReadAccountData readAccount = new ReadAccountData();
        AccessAccount myAccount = new AccessAccount();
        JsonObject json = (JsonObject) readAccount.getJsonObjectData(IdNumber);

        String hashStr = myAccount.convertAndGetJsonData("code", json);
        // System.out.println(code);
        boolean result = HashCode.verifyHash(code, hashStr);
        return result;
    }
}
