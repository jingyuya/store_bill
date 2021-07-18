package com.bill.xiaogu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.xiaogu.emums.RecordSortEnum;
import com.bill.xiaogu.entity.Record;
import com.bill.xiaogu.entity.User;
import com.bill.xiaogu.exception.ErrorParamException;
import com.bill.xiaogu.mapper.RecordMapper;
import com.bill.xiaogu.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RecordService extends ServiceImpl<RecordMapper, Record> {

    @Autowired
    private UserService userService;

    public void uploadFile(MultipartFile file, Integer accountId) {
        if (file.isEmpty()) {
            throw new ErrorParamException("文件不能为空");
        }
        try {
            //获取文件name
            String fileName = file.getOriginalFilename();
            log.info("fileName : " + fileName);
            //判断文件格式
            if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
                throw new ErrorParamException("上传文件格式错误:请上传后缀为.xls或.xlsx的文件");
            }
            boolean isExcel2003 = true;
            if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
                isExcel2003 = false;
            }
            InputStream is = file.getInputStream();
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet != null) {
                //notNull = true;
            }
            List<Record> listRecord = new ArrayList<>();
            Record record = null;
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                if(0 == i){
                    continue;
                }
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                record = this.getRecordByRow(record, row, accountId);
                listRecord.add(record);
            }
            this.saveOrUpdateBatch(listRecord);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Record getRecordByRow(Record record, Row row, Integer accountId) {
        //日期	登记人	分类	择要	操作人	收入	支出
        Double idD = row.getCell(0).getNumericCellValue();
        Integer id = idD.intValue();
        Date payDate = row.getCell(1).getDateCellValue();
        LocalDateTime payTime = TimeUtils.dateParseLocalDateTime(payDate);
        String registrantUserName = row.getCell(2).getStringCellValue();
        String sortName = row.getCell(3).getStringCellValue();
        String desc = row.getCell(4).getStringCellValue();
        String operatorUserName = row.getCell(5).getStringCellValue();
        Double in = row.getCell(6).getNumericCellValue();
        Double out = row.getCell(7).getNumericCellValue();
        Double amount = out;
        Integer type = -1;
        if (in != 0) {
            amount = in;
            type = 1;
        }

        User registrantUser = userService.getOne(new QueryWrapper<User>().eq("name", registrantUserName));
        User operatorUser = userService.getOne(new QueryWrapper<User>().eq("name", operatorUserName));
        if (null == registrantUser || operatorUser == null) {
            throw new ErrorParamException("请填写正确的登记人/操作人信息");
        }

        record = new Record();
        record.setId(id);
        record.setType(type);
        record.setSort(sortName);
        record.setPayDesc(desc);
        record.setPayAmount(amount);
        record.setPayTime(payTime);
        record.setOperatorUid(operatorUser.getId());
        record.setRegistrantUid(registrantUser.getId());
        record.setCreateTime(LocalDateTime.now());
        record.setUpdateTime(LocalDateTime.now());
        record.setAccountId(accountId);

        return record;
    }
}
