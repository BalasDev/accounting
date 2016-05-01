package com.accounting.my.service;

import com.accounting.my.dao.UserDAO;
import com.accounting.my.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Balas on 3/26/2016.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Override
    @Transactional
    public Users getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }

    @Override
    @Transactional
    public void createNewUser(Users user) {
        userDAO.createNewUser(user);
    }


}
