package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get a user by ID
    @GetMapping("/getUserById")
    public ResponseEntity<user> getUserById(@PathParam("id") Long id) {
        Optional<user> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Create a new user
    @GetMapping("/createUser")
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(
            @PathParam("dial") Long id,
            @PathParam("doi") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DOI,
            @PathParam("previousgiftsid") Integer previousGiftsId,
            @PathParam("giftid") Integer giftId) {
        userService.createUser(id, DOI, previousGiftsId, giftId);
        return ResponseEntity.ok("User created successfully.");
    }

//    http://localhost:8080/users/updateUserById?id=4&doi=2024-09-10&previousgiftsid=1&giftid=1
    @PutMapping("/updateUserById")
    public ResponseEntity<String> updateUser(
            @PathParam("id") Long id,
            @PathParam("doi") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DOI,
            @PathParam("previousgiftsid") Integer previousGiftsId,
            @PathParam("giftid") Integer giftId) {
        userService.updateUser(id, DOI, previousGiftsId, giftId);
        return ResponseEntity.ok("User updated successfully.");
    }

    // Delete a user by ID
    @GetMapping("/deleteUserById")
    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
