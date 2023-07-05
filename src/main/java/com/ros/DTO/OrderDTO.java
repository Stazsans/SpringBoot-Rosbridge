package com.ros.DTO;

import lombok.Data;

import java.util.HashMap;

@Data
public class OrderDTO {
    private Integer patientId;
    private HashMap<Integer, Integer> orderDrug;

}
