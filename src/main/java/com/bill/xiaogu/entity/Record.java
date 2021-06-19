package com.bill.xiaogu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


/**
 * 账户记录
 */
@Data
@TableName("t_record")
public class Record extends BaseEntity {


    @ApiModelProperty(value = "支付账户id")
    private Integer accountId;

    @ApiModelProperty(value = "支付类型：1收入 -1支出")
    private Integer type;

    @ApiModelProperty(value = "支付分类：上月报销 投资款 订单-收款 订单-退款 订单-错单退款 煤气-支出 煤气-收入 房租-支出 房租-收入 店铺-基本支出 店铺-基本收入 店铺-活动支出 进货-支出 进货-退款 提现-美团堂食 提现-美团外卖 提现-饿了么外卖 提现-废品 提现-充电宝 员工-基本支出 员工-工资支出 员工-房租支出 员工-退款收入")
    private Integer sort;

    @ApiModelProperty(value = "支付详情说明")
    private String payDesc;

    @ApiModelProperty(value = "数值大小")
    private Double payAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "出入帐操作人uid")
    private Integer operatorUid;

    @ApiModelProperty(value = "登记人uid")
    private Integer registrantUid;

}
