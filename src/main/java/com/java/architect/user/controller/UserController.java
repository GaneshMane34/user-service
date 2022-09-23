package com.java.architect.user.controller;

import com.java.architect.user.VO.ResponseTemplateVO;
import com.java.architect.user.entity.UserEntity;
import com.java.architect.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity user){
        log.info("-- Inside the User Controller post--");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id){
        log.info("-- Inside the User Controller Get--");
        return userService.getUserWithDepartment(id);
    }
}
