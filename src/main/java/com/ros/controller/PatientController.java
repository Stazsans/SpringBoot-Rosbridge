package com.ros.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ros.VO.PageInfo;
import com.ros.domain.Patient;
import com.ros.result.Result;
import com.ros.result.ResultUtil;
import com.ros.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patientList")
    @Operation(summary = "获取所有病人")
    public Result<List<Patient>> patientList() {
        try {
            List<Patient> patientList = patientService.list();
            return ResultUtil.success(patientList);
        } catch (Exception e) {
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
    }

    @Operation(summary = "分页查询病人信息")
    @GetMapping("/patientQueryPage")
    public Result<PageInfo<Patient>> patientQueryPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            QueryWrapper<Patient> patientQueryWrapper = new QueryWrapper<>();
            Page<Patient> patientPage = new Page<>(pageNum,pageSize,false);
            return ResultUtil.pageSuccess(patientService.page(patientPage,patientQueryWrapper));
        } catch (Exception e) {
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
    }
}
