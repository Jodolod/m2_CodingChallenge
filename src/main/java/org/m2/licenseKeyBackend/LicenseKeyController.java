package org.m2.licenseKeyBackend;

import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

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
