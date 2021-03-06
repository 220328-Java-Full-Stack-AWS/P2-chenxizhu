package com.revature.p2backend.beans.controllers;

import com.revature.p2backend.beans.services.UserService;
import com.revature.p2backend.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

//@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/currentuser")
    @ResponseStatus(HttpStatus.OK)
    public User viewUser(@RequestBody User user){
        System.out.println("You are now viewing the user");
        return userService.getUserByUserId(user);
    }


    @PostMapping("/register")
    ResponseEntity<User> createUser(@RequestBody User user) {
        Integer result = userService.save(user);
        switch(result){
            case 0:
                System.out.println("Successfully created new user");
                return new ResponseEntity<>(HttpStatus.OK);

            case 1:
                System.out.println("Username is not unique");
                return new ResponseEntity<>(HttpStatus.CONFLICT);

            case 2:
                System.out.println("User email is not unique");
                return new ResponseEntity<>(HttpStatus.CONFLICT);

            default:
                System.out.println("unable to create user");
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
    }


}
