package com.cy.springboot.service.impl;

import com.cy.springboot.pojo.User;
import com.cy.springboot.repository.UserRepository;
import com.cy.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void updateUser(User user)  {
        userRepository.findById(user.getId());
        user.setPassword(user.getPassword());
        user.setNick_name(user.getNick_name());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        user.setBirthday(user.getBirthday());
        userRepository.save(user);
    }
}
