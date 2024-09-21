package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;
import java.util.Date;


import java.util.Date;
@Entity
@Table(name = "GIFTS")
public class gift {
    @Id
    private Long giftId;
    private String description;
    private Float maxBonus;
    private int validity;
    private String capping;
    private String serviceClasses;
    private String offerAvailability;
    private Date expiryDate;

    // Getters and Setters
    public Long getGiftId() { return giftId; }
    public void setGiftId(Long giftId) { this.giftId = giftId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Float getMaxBonus() { return maxBonus; }
    public void setMaxBonus(Float maxBonus) { this.maxBonus = maxBonus; }

    public int getValidity() { return validity; }
    public void setValidity(int validity) { this.validity = validity; }

    public String getCapping() { return capping; }
    public void setCapping(String capping) { this.capping = capping; }

    public String getServiceClasses() { return serviceClasses; }
    public void setServiceClasses(String serviceClasses) { this.serviceClasses = serviceClasses; }

    public String getOfferAvailability() { return offerAvailability; }
    public void setOfferAvailability(String offerAvailability) { this.offerAvailability = offerAvailability; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }


}
