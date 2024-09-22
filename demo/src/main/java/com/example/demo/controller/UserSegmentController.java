package com.example.demo.controller;

import com.example.demo.model.SegmentGift;
import com.example.demo.model.UserSegment;
import com.example.demo.model.user;
import com.example.demo.services.AppService;
import com.example.demo.services.UserSegmentService;
import com.example.demo.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/segment")
public class UserSegmentController {

    @Autowired
    private UserSegmentService userSegmentService;

    public UserSegmentController(UserSegmentService userSegmentService) {
        this.userSegmentService = userSegmentService;
    }


    @GetMapping("/getGiftid")
    public ModelAndView getGiftid(@PathParam("dial") String dial) {
//ResponseEntity<String>
        // Retrieve user by id, handle Optional properly
        Optional<UserSegment> optionalUser = userSegmentService.findUserByDial(dial);

        ModelAndView modelAndView = new ModelAndView();

        if (optionalUser.isPresent()) {
            System.out.println(dial+" "+optionalUser.get().getUserId()+" "+optionalUser.get().getSegment());
            UserSegment existingUser = optionalUser.get();

            Object eligableGifts = userSegmentService.getSegmentGiftBySegment(existingUser.getSegment());
            System.out.println(eligableGifts);


            modelAndView.setViewName("success");
            modelAndView.addObject("message", "you are eligable for the following gifts"+eligableGifts);

        } else {
            modelAndView.addObject("message", "No gits eligable for ur category");
            modelAndView.addObject("dial", dial);
            modelAndView.setViewName("userDoesnotExist");

        }
        return modelAndView;
    }
}
