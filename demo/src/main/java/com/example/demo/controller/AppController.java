package com.example.demo.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.gift;
import com.example.demo.model.user;
import com.example.demo.services.AppService;
import com.example.demo.services.GiftService;
import com.example.demo.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;
    private UserService userService;

    public AppController(AppService appService, UserService userService) {
        this.appService = appService;
        this.userService = userService;
    }

    @GetMapping("/firstDownload")
    @PutMapping("/firstDownload")
    public ModelAndView firstDownload(@PathParam("dial") String dial) {
//ResponseEntity<String>
        // Retrieve user by id, handle Optional properly
        Optional<user> optionalUser = userService.getUserByDial(dial);

        ModelAndView modelAndView = new ModelAndView();

        if (optionalUser.isPresent()) {
        System.out.println(id+" "+optionalUser.get().getPreviousGiftsId()+" "+optionalUser.get().getGiftId());
            user existingUser = optionalUser.get();
  
            appService.firstDownload(existingUser.getId(), existingUser.getPreviousGiftsId(), existingUser.getGiftId());


            modelAndView.setViewName("success");
            modelAndView.addObject("message", "First download request sent successfully.");

        } else {
            modelAndView.addObject("message", "User not found.");
            modelAndView.addObject("dial", dial);
            modelAndView.setViewName("userDoesnotExist");

        }
        return modelAndView;
    }

    @GetMapping("/billpay")
    @PutMapping("/billpay")
    public ModelAndView billpay(@PathParam("dial") String dial , @PathParam("amount") Integer amount, @PathParam("method") String method) {

        // Retrieve user by id, handle Optional properly
        Optional<user> optionalUser = userService.getUserByDial(dial);

        ModelAndView modelAndView = new ModelAndView();

        if (optionalUser.isPresent()) {
            user existingUser = optionalUser.get();

            appService.billPayment(existingUser.getId(), existingUser.getGiftId(),amount,method);

            modelAndView.setViewName("success");
            modelAndView.addObject("message", "First download request sent successfully.");

        } else {
            modelAndView.setViewName("userDoesnotExist");
            modelAndView.addObject("message", "User not found.");
        }
        return modelAndView;
    }

    @GetMapping("/createNewUser")
    @PostMapping("/createNewUser")
    public ModelAndView createNewUser(
            @PathParam("dial") String dial) {
        ModelAndView modelAndView = new ModelAndView();

        appService.createNewUser(dial,  0, 0);

        modelAndView.setViewName("success");
        modelAndView.addObject("message", "user created successfully !");
        return modelAndView;
    }
}



