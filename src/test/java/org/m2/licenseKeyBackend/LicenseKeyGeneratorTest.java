package org.m2.licenseKeyBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.*;

import java.security.NoSuchAlgorithmException;

public class LicenseKeyGeneratorTest {
    private LicenseKeyGenerator licenseKeyGenerator;
    private String userNameAsTestValue = null;

    @BeforeEach
    public void setUp() throws Exception {
        licenseKeyGenerator = LicenseKeyGenerator.getInstance();
        userNameAsTestValue = licenseKeyGenerator.getLicenseKey("TestUsername@test.com");
    }

    @Test
    @DisplayName("Input username should not be equal to returned license key")
    public void testKeyGeneration () throws NoSuchAlgorithmException {
            String licenseKey = licenseKeyGenerator.getLicenseKey("TestUsername@test.com");
            System.out.println(licenseKey);
            assertNotEquals("TestUsername",licenseKey);

    }

    @RepeatedTest(5)
    @DisplayName("Same username should always produce same license key")
    public void testKeyGenerationMultiple() throws NoSuchAlgorithmException {
        String actualGeneratedLicenseKey = licenseKeyGenerator.getLicenseKey("TestUsername@test.com");
        assertEquals(userNameAsTestValue, actualGeneratedLicenseKey, "LicenseKey " + userNameAsTestValue + " == " + actualGeneratedLicenseKey );
    }
}
