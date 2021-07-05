package org.m2.licenseKeyBackend;

import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

/**
 * @desc The controller for the api it is very basic and no input checks or sanitation are done in any way. The responses are also very basic and are just true and false for a given email address/key combination or a new key for a provided email address.
 */

@RestController
public class LicenseKeyController {

    @PostMapping("/newlicensekey")
    String generateLicenseKeyRequest(@RequestParam String emailAddress) {
        String licenseKey = LicenseKeyGenerator.getInstance().getLicenseKey(emailAddress);
        return  "{\"licenseKey\":" + licenseKey + "}";
    }


    @PostMapping("/validate")
    boolean licenseKeyValidationRequest (@RequestParam String emailAddress, String licenseKey) {
        String supposedLicenseKey = LicenseKeyGenerator.getInstance().getLicenseKey(emailAddress);
        if(licenseKey.equals(supposedLicenseKey)){
            return true;
        }
        else {
            return false;
        }
    }
}
