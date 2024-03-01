package bankaccount;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {

    public static String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static boolean verifyHash(String original, String hashed) throws NoSuchAlgorithmException {
        String hashedInput = hashString(original);
        return hashedInput.equals(hashed);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // String originalString = "11530";
        // String hashedString = hashString(originalString);

        // System.out.println("Original String: " + originalString);
        // System.out.println("Hashed String: " + hashedString);

        // // Verifying the hash
        // boolean isMatch = verifyHash(originalString, hashedString);
        // System.out.println("Verification Result: " + isMatch);
    }
}
