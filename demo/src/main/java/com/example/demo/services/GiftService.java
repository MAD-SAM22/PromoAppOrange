package com.example.demo.services;

import com.example.demo.model.gift;
import com.example.demo.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public Optional<gift> getGiftById(Long giftId) {
        return giftRepository.findById(giftId);
    }

    public List<gift> getAllGifts() {
        return giftRepository.findAllGifts();
    }

    @Transactional
    public void addGift(Long giftId, String description, Float maxBonus, int validity, String capping, String serviceClasses, String offerAvailability, java.util.Date expiryDate) {
        giftRepository.insertGift(giftId, description, maxBonus, validity, capping, serviceClasses, offerAvailability, expiryDate);
    }

    @Transactional
    public void updateGift(Long giftId, String description, Float maxBonus, int validity, String capping, String serviceClasses, String offerAvailability, java.util.Date expiryDate) {
        giftRepository.updateGift(giftId, description, maxBonus, validity, capping, serviceClasses, offerAvailability, expiryDate);
    }

    @Transactional
    public void deleteGift(Long giftId) {
        giftRepository.deleteGift(giftId);
    }

}
