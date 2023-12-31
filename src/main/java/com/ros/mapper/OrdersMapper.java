package com.ros.mapper;

import com.ros.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ss
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-07-02 17:10:12
* @Entity com.ros.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}




