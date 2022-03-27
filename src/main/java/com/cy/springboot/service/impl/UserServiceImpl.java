package com.cy.springboot.service.impl;

import com.cy.springboot.pojo.User;
import com.cy.springboot.repository.UserRepository;
import com.cy.springboot.service.IUserService;
import com.cy.springboot.util.PageUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager em;

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

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    @Override
    public PageUtil findAllStudentByMyPage(int page, int size){

        /*分页查询数据*/
        Query query = em.createNativeQuery("SELECT * FROM user u LIMIT " + (page-1)*size + "," + size);
        List<User> userList = query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

        /*查询总共的数据条目*/
        query = em.createNativeQuery("SELECT COUNT(*) FROM user");
        Object object = query.getResultList().get(0);
        int totalElements = Integer.parseInt(object.toString());

        /*构建自定义Page对象*/
        PageUtil pageUtil = new PageUtil(size, page, totalElements);
        pageUtil.setNumberOfElements(userList.size());
        pageUtil.setContent(userList);

        return pageUtil;
    }


}
