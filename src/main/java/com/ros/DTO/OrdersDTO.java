package com.ros.DTO;

import lombok.Data;

import java.util.HashMap;

@Data
public class OrdersDTO {
    private String patientName;
    private HashMap<String, Integer> orderDrug;

}
