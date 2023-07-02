package com.ros.VO;

import lombok.Data;

import java.util.HashMap;

@Data
public class OrdersVO {
    private Integer id;
    private String createTime;
    private String orderState;
    private String createBy;
    private String patientName;
    private Integer boxId;
    private String ordersAddress;
}
