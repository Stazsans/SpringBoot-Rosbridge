package com.ros.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.DTO.OrderDTO;
import com.ros.domain.OrderDrug;
import com.ros.domain.Orders;
import com.ros.mapper.*;
import com.ros.service.OrderDrugService;
import com.ros.service.OrdersService;
import com.ros.service.PatientService;
import com.ros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
* @author ss
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{
    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private OrderDrugMapper orderDrugMapper;

    @Override
    public void orderAdd(OrderDTO orderDTO) {
        Orders orders = new Orders();
        Date dateTime = new Date();
        orders.setCreateTime(dateTime);
        orders.setOrderState(0);
        Integer loginId = (Integer) StpUtil.getLoginId();
        orders.setCreateBy(userMapper.selectById(loginId).getUserName());
        orders.setPatientId(orderDTO.getPatientId());
        orders.setOrderAddress(patientMapper.selectById(orderDTO.getPatientId()).getPatientAddress());
        //TODO 调度药箱
        orders.setBoxId(1);
        int orderId = ordersMapper.insert(orders);
        for(Map.Entry<Integer, Integer> entry: orderDTO.getOrderDrug().entrySet()) {
            OrderDrug orderDrug = new OrderDrug();
            orderDrug.setOrderId(orderId);
            orderDrug.setDrugId(entry.getKey());
            orderDrug.setDrugName(drugMapper.selectById(entry.getKey()).getDrugName());
            orderDrug.setDrugNumber(entry.getValue());
            orderDrugMapper.insert(orderDrug);
        }
    }

    @Override
    public void orderDelById(Integer id) {
        ordersMapper.deleteById(id);
        QueryWrapper<OrderDrug> orderDrugQueryWrapper = new QueryWrapper<>();
        orderDrugQueryWrapper.eq("order_id",id);
        orderDrugMapper.delete(orderDrugQueryWrapper);
    }
}




