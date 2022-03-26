package com.cy.springboot.service;

import com.cy.springboot.pojo.User;

import java.text.ParseException;

public interface IUserService {

    void updateUser(User user) throws ParseException;

}
