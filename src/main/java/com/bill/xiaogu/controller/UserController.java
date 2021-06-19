package com.bill.xiaogu.controller;

import com.bill.xiaogu.dto.UserDTO;
import com.bill.xiaogu.dto.WrapMapper;
import com.bill.xiaogu.dto.Wrapper;
import com.bill.xiaogu.entity.User;
import com.bill.xiaogu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("保存用户")
    @PostMapping("/saveOrUpdate")
    public Wrapper<User> saveOrUpdate(@RequestBody UserDTO userDTO) {
        User user = userService.saveOrUpdateOne(userDTO);
        return WrapMapper.ok(user);
    }

}
