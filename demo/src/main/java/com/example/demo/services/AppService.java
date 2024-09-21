package com.example.demo.services;

import com.example.demo.model.gift;
import com.example.demo.model.user;
import com.example.demo.repository.AppRepository;
import com.example.demo.repository.GiftRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.BreakIterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AppService {

    private GiftRepository giftRepository;
    private UserRepository userRepository;
    private AppRepository appRepository;

    @Autowired
    public AppService(GiftRepository giftRepository, UserRepository userRepository, AppRepository appRepository) {
        this.giftRepository = giftRepository;
        this.userRepository = userRepository;

        this.appRepository = appRepository;
    }

    @Transactional
    public void firstDownload(Long userId, Integer previousGiftsId, Integer giftId) {
        // Check if it's the first download
        if (previousGiftsId == 0) {
            previousGiftsId = 1;
            giftId = 1;
        }
        appRepository.firstDownload(userId, previousGiftsId, giftId);
    }

    @Transactional
    public void billPayment(Long userId,Integer giftId, Integer amount, String method ) {
        int bonus;
        if (method == "credit" && amount >= 50) {

            if (giftId == 2){
                bonus = amount*2;
                bonus = Math.min(bonus, 2000);
                appRepository.billpay(userId, giftId);
            }
            else if (giftId == 3)
            {
                bonus = amount*2;
                bonus = Math.min(bonus, 3000);
                appRepository.billpay(userId, giftId);

            }
            else if (giftId >= 4)
            {
                bonus = amount*2;
                bonus = Math.min(bonus, 5000);
                appRepository.billpay(userId, giftId);

            }

        }
        //System.out.println("Query called");
    }
    @Transactional
    public void createNewUser(String dial,Integer previousGiftsId,Integer giftId ) {

        Date currentDate = new Date();

        appRepository.createNewUser(dial,currentDate, previousGiftsId,giftId);

    }
}
