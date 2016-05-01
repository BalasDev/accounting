package com.accounting.my.service;

import com.accounting.my.model.Users;

import java.util.List;

/**
 * Created by Balas on 3/26/2016.
 */
public interface UserService {
    Users getUserByLogin(String login);
    void createNewUser(Users user);
}
