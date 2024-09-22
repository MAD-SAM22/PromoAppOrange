package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "segment_gifts")
public class SegmentGift {

    // Fields
    @Id
    private String segment; // Primary key
    private int giftId;

    // Constructor
    public SegmentGift(String segment, int giftId) {
        this.segment = segment;
        this.giftId = giftId;
    }

    // Default constructor (optional)
    public SegmentGift() {}

    // Getters and Setters
    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    // toString method for debugging and display purposes
    @Override
    public String toString() {
        return "SegmentGift{" +
                "segment='" + segment + '\'' +
                ", giftId=" + giftId +
                '}';
    }

    // Equals and hashCode methods to treat 'segment' as the primary key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentGift that = (SegmentGift) o;
        return segment.equals(that.segment);
    }

    @Override
    public int hashCode() {
        return segment.hashCode();
    }
}
