package com.ros.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ros.DTO.OrderDTO;
import com.ros.VO.PageInfo;
import com.ros.domain.OrderDrug;
import com.ros.domain.Orders;
import com.ros.result.Result;
import com.ros.service.OrdersService;
import com.ros.sseEmitter.SseEmitterServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ros.result.ResultUtil;

import java.util.List;
import java.util.Map;

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
            log.error(e.toString());
            return ResultUtil.defineFail(500, "服务器内部错误");
        }
    }

    /**
     * 根据药单id查询药品及药品数量
     */
    @GetMapping("queryOrderDrugById/{id}")
    @Operation(summary = "根据药单查询药品名及数量")
    public Result<List<OrderDrug>> queryOrderDrugById(@PathVariable Long id) {
        try {
            return ResultUtil.success(ordersService.queryOrderDrugById(id));
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500, "服务器内部错误");
        }
    }

    /**
     * 添加一个药单信息
     */
    @PostMapping("/orderAdd")
    @Operation(summary = "新增药单")
    public <T> Result<T> orderAdd(@RequestBody OrderDTO orderDTO) {
        try {
            ordersService.orderAdd(orderDTO);
            SseEmitterServer.sendMessage("admin", "有新的药单信息，请注意查收");
            return ResultUtil.success("创建成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500, "服务器内部错误");
        }
    }

    /**
     * 删除一个药单信息
     */
    @DeleteMapping("/orderDelById/{id}")
    @Operation(summary = "根据id删除药单")
    public Result<?> orderDelById(@PathVariable Long id) {
        try {
            ordersService.orderDelById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.fail(e.toString());
        }
    }

    /**
     * 修改药单
     */
    @PutMapping("/orderUpdate/{orderId}")
    @Operation(summary = "修改药单")
    public Result<?> orderUpdate(@PathVariable Long orderId, @RequestBody Map<Long, Integer> orderDrug) {
        try {
            ordersService.orderUpdate(orderId, orderDrug);
            return ResultUtil.success("修改成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.fail(e.toString());
        }
    }

    /**
     * 完成药物装配
     */
    @GetMapping("/completeAssembly/{orderId}")
    @Operation(summary = "完成药物装配接口")
    public Result<?> completeAssembly(@PathVariable Long orderId) {
        try {
            Orders order = new Orders();
            order.setOrderState(1);
            order.setId(orderId);
            ordersService.updateById(order);
            return ResultUtil.success("状态更新成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.fail(e.toString());
        }
    }

    /**
     * 完成药物配送
     */
    @GetMapping("/completeDelivery/{orderId}")
    @Operation(summary = "完成药物配送")
    public Result<?> completeDelivery(@PathVariable Long orderId) {
        try {
            Orders order = new Orders();
            order.setOrderState(2);
            order.setId(orderId);
            ordersService.updateById(order);
            SseEmitterServer.batchSendMessage("药单号为" + orderId.toString() + "的药单配送成功");
            return ResultUtil.success("状态更新成功");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.fail(e.toString());
        }
    }
}
