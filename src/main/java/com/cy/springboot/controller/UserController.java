package com.cy.springboot.controller;

import com.cy.springboot.pojo.User;
import com.cy.springboot.repository.UserRepository;
import com.cy.springboot.service.IUserService;
import com.cy.springboot.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "测试接口", tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/save")
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Result saveUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return Result.success(save);
    }

    @GetMapping(value = "findById/{id}")
    @ApiOperation(value = "根据id获取用户信息",notes = "根据id获取用户信息")
    public Result getUser(@PathVariable Integer id){
        User user = userRepository.findById(id).get();
        return Result.success(user);
    }

    @GetMapping(value = "findAll")
    @ApiOperation(value = "查询所有用户",notes = "查询所有用户")
    public Result findAll(){
        List<User> all = userRepository.findAll();
        return Result.success(all);
    }


    @RequestMapping(value = "deleteById/{id}")
    @ApiOperation(value = "根据id删除一条记录",notes = "根据id删除用户信息")
    public Result deleteById(@PathVariable Integer id){
        userRepository.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "deleteInBatch")
    @ApiOperation(value = "根据多条id删除多条记录",notes = "根据多条id删除多条记录")
    public Result deleteInBatch(){
        userRepository.deleteAllByIdInBatch(Arrays.asList(32,34));
        return Result.success();
    }

    @RequestMapping(value = "update")
    @ApiOperation(value = "根据id更改一条记录",notes = "根据id更改用户信息")
    public Result updateUser(@RequestBody User user) throws ParseException {
        userService.updateUser(user);
        return Result.success();
    }
}
