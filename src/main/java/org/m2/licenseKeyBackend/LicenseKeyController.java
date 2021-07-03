package org.m2.licenseKeyBackend;

import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
public class LicenseKeyController {

    LicenseKeyController(){
        //There should be a class that validates Keys and one that makes them initialized here
    }


    @RequestMapping ("/")
    String landingPage (){
        String test = "Test";
        return test;
    }

    @GetMapping("/newlicensekey")
    String generateLicenseKeyRequest() throws NoSuchAlgorithmException {
        String licenseKey = LicenseKeyGenerator.getInstance().getLicenseKey("TestUser@test.com");
        return  "{\"licenseKey\":" + licenseKey + "}";
    }


    @PostMapping("/validate")
    boolean licenseKeyValidationRequest (@RequestBody LicenseKey licenseKey) throws NoSuchAlgorithmException {
        String supposedLicenseKey = LicenseKeyGenerator.getInstance().getLicenseKey(licenseKey.getEmailAdress());
        if(licenseKey.getLicenseKey().equals(supposedLicenseKey)){
            return true;
        }
        else {
            return false;
        }
    }
}
