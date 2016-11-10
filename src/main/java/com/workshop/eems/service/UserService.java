package com.workshop.eems.service;

import com.workshop.eems.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    boolean usernameExists(String username);

    User findByUsername(String username);

    List<String> findAuthorities(Long id);

    boolean isAuthenticated();

    User getCurrent();

    String getCurrentUsername();

}