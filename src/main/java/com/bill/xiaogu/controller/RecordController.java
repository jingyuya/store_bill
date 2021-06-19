package com.bill.xiaogu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.xiaogu.dto.RecordAddDTO;
import com.bill.xiaogu.dto.WrapMapper;
import com.bill.xiaogu.dto.Wrapper;
import com.bill.xiaogu.entity.Account;
import com.bill.xiaogu.entity.Record;
import com.bill.xiaogu.service.AccountService;
import com.bill.xiaogu.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Api("账户记录管理")
@RequestMapping("/record")
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private AccountService accountService;

    @ApiOperation("导入文件")
    @PostMapping("/file/upload")
    public Wrapper<String> fileUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        Integer accountId = request.getIntHeader("accountId");
        if(null == accountId){
            WrapMapper.error("header accountId is null");
        }
        Account account = accountService.getById(accountId);
        if(null == account){
            WrapMapper.error("header accountId is error");
        }
        recordService.uploadFile(file,accountId);
        return WrapMapper.ok("上传成功");
    }

    @ApiModelProperty("批量获取")
    @PostMapping("/list")
    public Wrapper<List<Record>> addBatch(){
        return WrapMapper.ok(recordService.getBaseMapper().selectList(new QueryWrapper<Record>().orderByDesc("id")));
    }

}
