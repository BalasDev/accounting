package com.accounting.my.controllers;


import com.accounting.my.model.Roles;
import com.accounting.my.model.Users;
import com.accounting.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balas on 3/16/2016.
 */
@RestController
public class HomeController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public  void getUser(@RequestBody Users user) {

        userService.createNewUser(user);
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    }
