package com.one.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.onetoone.model.User;
import com.one.onetoone.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "/all-users")
    public List<User> findAllUsersById() {
        return userService.getAllUsers();
    }

    @PutMapping(value = "/update/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") long id) {
        userService.deletUser(id);
    }

}
