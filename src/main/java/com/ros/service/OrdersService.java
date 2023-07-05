package com.ros.service;

import com.ros.DTO.OrderDTO;
import com.ros.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ss
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-07-02 15:59:40
*/
public interface OrdersService extends IService<Orders> {

    void orderAdd(OrderDTO orderDTO);

    void orderDelById(Integer id);
}
