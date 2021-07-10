package org.m2.licenseKeyBackend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * There are not setters because all interactions with the data of this class should be through the database
 */
@Entity

public class LicenseKey {


    @Id
    @Column (name="licensekey")
    private String licenseKey;

    @Column(name="emailaddress")
    private String emailAddress;

    /**
     * Empty default constructor is necessary for db interactions to work
     */
    public LicenseKey(){
    }

    public LicenseKey(String licenseKey, String emailAddress){
        this.licenseKey = licenseKey;
        this.emailAddress = emailAddress;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
