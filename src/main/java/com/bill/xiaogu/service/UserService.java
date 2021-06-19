package com.bill.xiaogu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.xiaogu.dto.UserDTO;
import com.bill.xiaogu.entity.User;
import com.bill.xiaogu.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public User saveOrUpdateOne(UserDTO userDTO){
        User user = this.getOne(new QueryWrapper<User>()
                .eq("name",userDTO.getName())
                .eq("sex", userDTO.getSex())
                .eq("type", userDTO.getType()));
        if(null ==user){
            user = new User();
            user.setName(userDTO.getName());
            user.setSex(userDTO.getSex());
            user.setType(userDTO.getType());
            user.setCreateTime(LocalDateTime.now());
        }
        user.setIdCardNo(userDTO.getIdCardNo());
        user.setUpdateTime(LocalDateTime.now());
        this.saveOrUpdate(user);
        return user;
    }

}
