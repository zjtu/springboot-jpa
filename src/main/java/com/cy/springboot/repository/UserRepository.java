package com.cy.springboot.repository;

import com.cy.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Query("update User set username=:username  where id=:id")
    @Transactional
    int updatePasswordByUsername(@Param("username") String username, @Param("id") Integer id);

}
