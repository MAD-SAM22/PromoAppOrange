package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;



@Entity
@Table(name = "USERS")
public class user {

    @Id
    private Long id;

    private String dial;

    private Date doi;


    private Integer giftId;


    private Integer previousGiftsId;

    public void setDial(String dial) {
        this.dial = dial;
    }

    public String getDial() {
        return dial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDOI() {
        return doi;
    }

    public void setDOI(Date DOI) {
        this.doi = DOI;
    }


    public int getPreviousGiftsId() {
        return previousGiftsId;
    }

    public void setPreviousGiftsId(int previousGiftsId) {
        this.previousGiftsId = previousGiftsId;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }


}
