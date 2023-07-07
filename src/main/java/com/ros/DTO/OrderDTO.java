package com.ros.DTO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class OrderDTO {
    private Integer patientId;
    private Map<Integer, Integer> orderDrug;

}
