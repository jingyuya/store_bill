package com.bill.xiaogu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 账户
 */
@Data
@TableName(value = "t_account")
public class Account extends BaseEntity {

    @ApiModelProperty(value = "账户号码")
    private String accountNo;

    @ApiModelProperty(value = "账户类型: 1-中国银行卡、2-支付宝账户、3-微信账户、4-农行账户")
    private Integer type;

    @ApiModelProperty(value = "余额")
    private Double balance;


}
