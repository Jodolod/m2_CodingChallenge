package org.m2.licenseKeyBackend;

import org.springframework.web.bind.annotation.*;

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
    String generateLicenseKeyRequest(){
        return "fakeLicenseKey";
    }


    @PostMapping("/validate")
    boolean licenseKeyValidationRequest (@RequestBody LicenseKey licenseKey){
        System.out.println(licenseKey.getLicenseKey());
        if(licenseKey.getLicenseKey() == "TestKey"){
            return true;
        }
        else {
            return false;
        }
    }
}
