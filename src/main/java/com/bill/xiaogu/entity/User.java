package com.bill.xiaogu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User extends BaseEntity {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别：F女 M男")
    private String sex;

    @ApiModelProperty(value = "用户类型：1老板 2店长 3普通员工")
    private Integer type;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNo;

}
