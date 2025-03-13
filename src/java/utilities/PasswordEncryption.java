package utilities;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PasswordEncryption {

    
    
    public static String encryptPassword(String password) {
        return Hashing.sha256()
            .hashString(password + new Salt().salt, StandardCharsets.UTF_8)
            .toString();
    }


    public static boolean checkPassword(String password, String hashedPassword) {
        String hashedInput = encryptPassword(password);
        return hashedInput.equals(hashedPassword);
    }
    
    public static void main(String[] args) {
        String pass = "gay";
        System.out.println(checkPassword(pass, "c434e4530d985edbe83a7a0977a4f727d09f588fee07b5e6cabe8db02342fc55"));
//        byte[] salt = new byte[16];
//        new SecureRandom().nextBytes(salt);
//        System.out.println(Base64.getEncoder().encodeToString(salt));
    }
}


