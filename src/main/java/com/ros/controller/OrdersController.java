package com.ros.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ros.DTO.OrderDTO;
import com.ros.VO.PageInfo;
import com.ros.domain.Orders;
import com.ros.result.Result;
import com.ros.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ros.result.ResultUtil;

import java.util.Date;

@RestController
@RequestMapping("/orders")
@Tag(name = "药单模块相关接口")
@Slf4j
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 分页查询药单信息列表
     */
    @GetMapping("/orderQueryPage")
    @Operation(summary = "分页查询药单")
    public Result<PageInfo<Orders>> orderQueryPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "-1") Integer orderState) {
        try {
            QueryWrapper<Orders> ordersQueryWrapper = new QueryWrapper<>();
            if (orderState != -1) {
                ordersQueryWrapper.eq("order_state", orderState);
            }
            Page<Orders> ordersPage = new Page<>(pageNum, pageSize, false);
            return ResultUtil.pageSuccess(ordersService.page(ordersPage, ordersQueryWrapper));
        } catch (Exception e) {
            return ResultUtil.defineFail(500, "服务器内部错误");
        }
    }

    /**
     * 添加一个药单信息
     */
    @PostMapping("/orderAdd")
    @Operation(summary = "新增药单")
    public <T> Result<T> orderAdd(OrderDTO orderDTO) {
        try {
            ordersService.orderAdd(orderDTO);
            return ResultUtil.success("创建成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
    }

    /**
     * 删除一个药单信息
     */
    @DeleteMapping("/orderDelById")
    @Operation(summary = "根据id删除药单")
    public Result<?> orderDelById(Integer id) {
        try{
            ordersService.orderDelById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.fail(e.toString());
        }
    }

    @PutMapping
    @Operation(summary = "修改药单")
    public Result<?> orderUpdate() {
        return null;
    }
}
