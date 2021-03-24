package fi.utu.tech.gui.javafx.assignment2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Sum {

    public static String calculateMD5Sum(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        var sum = md.digest(input.getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();
        for (byte b : sum) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}
