package com.bill.xiaogu.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别：F女 M男")
    private String sex;

    @ApiModelProperty(value = "用户类型：1老板 2店长 3普通员工")
    private Integer type;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNo;
}
