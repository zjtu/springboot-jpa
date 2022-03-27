package com.cy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id",nullable = false,columnDefinition = "int(11) COMMENT '用户id'")
    private Integer id;

    @Column(name = "username",columnDefinition = "varchar(50) COMMENT '用户名'")
    private String  username;

    @Column(name = "password")
    private String password;

    @Column(name = "nick_name")
    private String nick_name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String  email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
    @Column(name = "age")
    private Integer age;
}
