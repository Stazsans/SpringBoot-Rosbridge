package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.Orders;
import com.ros.service.OrdersService;
import com.ros.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




