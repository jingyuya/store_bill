package com.bill.xiaogu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.xiaogu.dto.AccountCreateDTO;
import com.bill.xiaogu.entity.Account;
import com.bill.xiaogu.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    public Account saveOrUpdateOne(AccountCreateDTO accountCreateDTO) {
        Account account = this.getOne(new QueryWrapper<Account>()
                .eq("account_no", accountCreateDTO.getAccountNo())
                .eq("type", accountCreateDTO.getAccountType()));
        if (null == account) {
            account = new Account();
            account.setAccountNo(accountCreateDTO.getAccountNo());
            account.setType(accountCreateDTO.getAccountType());
            account.setCreateTime(LocalDateTime.now());
        }
        account.setUpdateTime(LocalDateTime.now());
        account.setBalance(accountCreateDTO.getBalance());
        this.saveOrUpdate(account);
        return account;
    }

}
