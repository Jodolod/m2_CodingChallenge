package org.m2.licenseKeyBackend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Nikolai Hartmayer
 * @desc LicenseKeyGenerator to generate the license keys. This implementation would not be thread save
 */
public class LicenseKeyGenerator {
    private static LicenseKeyGenerator instance;

    private LicenseKeyGenerator (){}

    public static LicenseKeyGenerator getInstance(){
        if (LicenseKeyGenerator.instance == null){
            LicenseKeyGenerator.instance = new LicenseKeyGenerator();
        }
        return LicenseKeyGenerator.instance;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String get_SHA_256_licenseKey(String username)throws NoSuchAlgorithmException{
        String generatedLicenseKey = null;
        byte[] salt = getSalt();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(username.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedLicenseKey = sb.toString();
            }
        catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        return generatedLicenseKey;
    }
}
