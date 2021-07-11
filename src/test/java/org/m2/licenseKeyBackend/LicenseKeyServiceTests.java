package org.m2.licenseKeyBackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
public class LicenseKeyServiceTests {

    @Autowired
    LicenseKeyService licenseKeyService;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    public void getNewLicenseKey_thenValidateTheKeyInDatabase(){
        LicenseKey licenseKey = licenseKeyService.getNewLicenseKey("TestUsername@test.com");
        boolean isValidKey = licenseKeyService.validateLicenseKey(licenseKey.getLicenseKey());
        assertTrue(isValidKey, "The created licenese key was validated in the database");
    }

    @Test
    public void getNewLicenseKey_thenDeleteTheKeyFromTheDatabase(){
        LicenseKey licenseKey = licenseKeyService.getNewLicenseKey("TestUsername@test.com");
        boolean isDeleted = licenseKeyService.deleteLicenseKey(licenseKey.getLicenseKey());
        boolean isValidKey = licenseKeyService.validateLicenseKey(licenseKey.getLicenseKey());
        assertTrue(isDeleted, "The license Key was deleted");
        assertFalse("The license key is no longer valid", isValidKey);
    }
}
