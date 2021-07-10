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
            return new LicenseKey("Key already exists", null);
        }
        licenseKeyRepository.save(licenseKey);
        return  licenseKey;
    }


    public LicenseKey getLicenseKey(String emailAddress){
        return licenseKeyRepository.findById(LicenseKeyGenerator.getInstance().getLicenseKey(emailAddress)).get();
    }


    public boolean validateLicenseKey(String emailAddress, String licenseKey){
        String supposedLicenseKey = LicenseKeyGenerator.getInstance().getLicenseKey(emailAddress);
        if(licenseKey.equals(supposedLicenseKey)){
            return true;
        }
        else {
            return false;
        }
    }
}
