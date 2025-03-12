package utilities;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class PasswordEncryption {


    public static String encryptPassword(String password) {
        return BCrypt.withDefaults().hashToString(10, password.toCharArray());
    }


    public static boolean checkPassword(String password, String hashedPassword) {
        return encryptPassword(password).equals(hashedPassword);
    }
}


