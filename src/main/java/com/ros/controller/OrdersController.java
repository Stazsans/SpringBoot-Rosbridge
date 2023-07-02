package com.ros.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ros.domain.Orders;
import com.ros.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Tag(name ="药单模块相关接口")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 分页查询药单信息列表
     */
    @GetMapping(value = "/orderQueryPage")
    @Operation(summary = "分页查询药单")
    public Object orderQueryPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {

            IPage<Orders> iPage = ordersService.page();
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
