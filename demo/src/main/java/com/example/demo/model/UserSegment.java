package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_segments")
public class UserSegment {
    @Id
    private int userId;
    private int dial;
    private String segment;

    public UserSegment() {

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDial(int dial) {
        this.dial = dial;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public int getUserId() {
        return userId;
    }

    public int getDial() {
        return dial;
    }

    public String getSegment() {
        return segment;
    }

    public UserSegment(int userId, int dial, String segment) {
        this.userId = userId;
        this.dial = dial;
        this.segment = segment;
    }
}
