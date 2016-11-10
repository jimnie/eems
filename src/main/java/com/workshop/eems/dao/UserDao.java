package com.workshop.eems.dao;

import com.workshop.eems.entity.User;

public interface UserDao extends BaseDao<User, Long> {

    boolean usernameExists(String username);

    User findByUsername(String username);

}