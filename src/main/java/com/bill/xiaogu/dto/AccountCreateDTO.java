package com.bill.xiaogu.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AccountCreateDTO {

    @ApiModelProperty(value = "账户号码")
    private String accountNo;

    @ApiModelProperty(value = "账户类型:中国银行卡、支付宝账户、微信账户、农行账户")
    private int accountType;

    @ApiModelProperty(value = "余额")
    private Double balance;
}
