package com.ros.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ros.VO.PageInfo;
import com.ros.domain.Drug;
import com.ros.result.Result;
import com.ros.result.ResultUtil;
import com.ros.service.DrugService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drug")
@Tag(name ="药品模块相关接口")
@Slf4j
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("/drugList")
    @Operation(summary = "获取所有药品")
    public Result<List<Drug>> drugList() {
        try {
            List<Drug> drugList = drugService.list();
            return ResultUtil.success(drugList);
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
    }

    @Operation(summary = "分页查询药品信息")
    @GetMapping("/drugQueryPage")
    public Result<PageInfo<Drug>> drugQueryPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            QueryWrapper<Drug> drugQueryWrapper = new QueryWrapper<>();
            Page<Drug> drugPage = new Page<>(pageNum,pageSize,false);
            return ResultUtil.pageSuccess(drugService.page(drugPage,drugQueryWrapper));
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
    }
}
