package com.bill.xiaogu.controller;

import com.bill.xiaogu.dto.AccountCreateDTO;
import com.bill.xiaogu.dto.WrapMapper;
import com.bill.xiaogu.dto.Wrapper;
import com.bill.xiaogu.entity.Account;
import com.bill.xiaogu.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Api(value = "账户管理")
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("保存用户")
    @PostMapping("/saveOrUpdate")
    public Wrapper<Account> saveOrUpdate(@RequestBody AccountCreateDTO accountCreateDTO) {
        Account account = accountService.saveOrUpdateOne(accountCreateDTO);
        return WrapMapper.ok(account);
    }

}
