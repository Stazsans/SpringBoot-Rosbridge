package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.OrderDrug;
import com.ros.service.OrderDrugService;
import com.ros.mapper.OrderDrugMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【order_drug】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class OrderDrugServiceImpl extends ServiceImpl<OrderDrugMapper, OrderDrug>
    implements OrderDrugService{

}




