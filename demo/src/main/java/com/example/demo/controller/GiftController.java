package com.example.demo.controller;

import com.example.demo.model.gift;
import com.example.demo.services.GiftService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    // Get a gift by ID
    @GetMapping("/getGiftById")
    public ResponseEntity<gift> getGiftById(@PathParam("giftId") Long giftId) {
        Optional<gift> gift = giftService.getGiftById(giftId);
        return gift.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all gifts
    @GetMapping("/getAllGifts")
    public ResponseEntity<List<gift>> getAllGifts() {
        List<gift> gifts = giftService.getAllGifts();
        return ResponseEntity.ok(gifts);
    }

    //  http://localhost:8080/gifts/createGift?giftId=5&description=mine&maxBonus=0&validity=30&capping=No&serviceClasses=all&offerAvailability=in%20stock&expiryDate=2025-11-18


    // Update an existing gift
    @GetMapping("/updateGiftById")
    @PutMapping("/updateGiftById")
    public ResponseEntity<String> updateGift(
            @PathParam("giftId") Long giftId,
            @PathParam("description") String description,
            @PathParam("maxBonus") Float maxBonus,
            @PathParam("validity") int validity,
            @PathParam("capping") String capping,
            @PathParam("serviceClasses") String serviceClasses,
            @PathParam("offerAvailability") String offerAvailability,
        @PathParam("expiryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expiryDate) {
        giftService.updateGift(giftId, description, maxBonus, validity, capping, serviceClasses, offerAvailability, expiryDate);
        return ResponseEntity.ok("Gift updated successfully.");
    }

    // Delete a gift by ID
    @GetMapping("/deleteGiftById")
    @DeleteMapping("/deleteGiftById")
    public ResponseEntity<String> deleteGift(@PathParam("giftid") Long giftId) {
        giftService.deleteGift(giftId);
        return ResponseEntity.ok("Gift deleted successfully.");
    }
}
