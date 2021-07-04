package org.m2.licenseKeyBackend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Nikolai Hartmayer
 * @desc LicenseKeyGenerator to generate the license keys. This implementation would not be thread save nor is the generated license key secure in anyway it is just for demonstration purposes
 * Also no salt is used generating the hash which makes it even less secure just concatenated with a long random string
 */
public class LicenseKeyGenerator {
    private static LicenseKeyGenerator instance;
    private static final String privateKey = "ca00ebf34ce4c5c0cb10d00bd7041959e941bbc6ff8db8383107a3fa3b9189e3435bf7a6151a80e09c5100beb7e8beba8ae2225bdcbf60fb7e787e4ed38a00bc95854a460cc6f03b9d9498a58dd6e6c4543c392efb885a492d81f1cfa8853117bb62aa2ef4a5fdffa0dbf121483acc82f65ab542b93c7f58ece91a46b0eaa599c8724cd241dad49fdbc32fcc041028b1d7699578189b5ab8f8bac556266a77be 1317e7dd2185390bb7f6078d8d3296825f49e1cd184e35abaf11b45f87bfdeb885b8380b15668756dd3cf36dba9688d1aba25beda4536dca6457f8b972f4f35a8cc60279a137b6d9af5f09944946bfb759c9bd853cccbb857194718aa2b8a3bc28998b3b849f711570d8465b4019357d57339b07a5b205e300c82a786a1da2e240f662f252f51335b9abfd88948c0b7edf010fcbdeda46a137502ccaacdac84d";

    private LicenseKeyGenerator (){}

    public static LicenseKeyGenerator getInstance(){
        if (LicenseKeyGenerator.instance == null){
            LicenseKeyGenerator.instance = new LicenseKeyGenerator();
        }
        return LicenseKeyGenerator.instance;
    }

    public String getLicenseKey(String email){
        String licenseKey = getSHA256licenseKey(email + privateKey);
        return licenseKey;
    }

    private static String getSHA256licenseKey(String email){
        String generatedLicenseKey = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(email.getBytes(StandardCharsets.UTF_8));
            generatedLicenseKey = Base64.getEncoder().encodeToString(hash);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            }
        return generatedLicenseKey;
    }
}
