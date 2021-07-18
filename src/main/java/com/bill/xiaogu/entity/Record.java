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

    @ApiModelProperty(value = "支付分类")
    private String sort;

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
