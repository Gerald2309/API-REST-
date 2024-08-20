package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {

        return this.userService.saveUser(user);

    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Optional<UserModel> updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
        return this.userService.update(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "User deleted";
        }else {
            return "User not found";
        }

    }



}
