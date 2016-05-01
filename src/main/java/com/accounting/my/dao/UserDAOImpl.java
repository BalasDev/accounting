package com.accounting.my.dao;

import com.accounting.my.model.Roles;
import com.accounting.my.model.Users;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Balas on 3/26/2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Users getUserByLogin(String login) {
        String sql = "SELECT * FROM USERS WHERE USERS.LOGIN = :LOGIN";
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql)
                .addEntity(Users.class)
                .setParameter("LOGIN",login);
        return (Users) query.list().get(0);
    }

    @Override
    public void createNewUser(Users users) {
        Roles role = (Roles)sessionFactory.getCurrentSession().get(Roles.class,2);
        users.setRole(role);
       // sessionFactory.getCurrentSession().save(users.getPersonalInformation());
        sessionFactory.getCurrentSession().save(users);
    }
}
