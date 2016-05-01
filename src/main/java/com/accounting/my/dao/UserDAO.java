package com.accounting.my.dao;

import com.accounting.my.model.Users;

import java.util.List;

/**
 * Created by Balas on 3/26/2016.
 */
public interface UserDAO {
    Users getUserByLogin(String login);
    void  createNewUser(Users users);
}
