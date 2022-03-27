package com.cy.springboot.service;

import com.cy.springboot.pojo.User;
import com.cy.springboot.util.PageUtil;

import java.text.ParseException;
import java.util.List;

public interface IUserService {

    void updateUser(User user) throws ParseException;


    List<User> findAllUser();


    PageUtil findAllStudentByMyPage(int page, int size);
}
