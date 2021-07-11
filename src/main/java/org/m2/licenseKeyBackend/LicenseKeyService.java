package org.m2.licenseKeyBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseKeyService {

    @Autowired
    LicenseKeyRepository licenseKeyRepository;

    public LicenseKey getNewLicenseKey(String emailAddress){
        String licenseKeyString = LicenseKeyGenerator.getInstance().getLicenseKey(emailAddress);
        LicenseKey licenseKey = new LicenseKey(licenseKeyString, emailAddress);
        if(licenseKeyRepository.existsById(licenseKey.getLicenseKey())){
            return new LicenseKey("This email address was already used to obtain a license key ", null);
        }
        licenseKeyRepository.save(licenseKey);
        return  licenseKey;
    }


    public boolean validateLicenseKey(String licenseKey){
        if(licenseKeyRepository.existsById(licenseKey)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteLicenseKey(String licenseKey){
        if(licenseKeyRepository.existsById(licenseKey)){
            licenseKeyRepository.deleteById(licenseKey);
            return true;
        }
        else {
            return false;
        }
    }
}
