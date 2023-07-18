package com.ros.VO;

import lombok.Data;

@Data
public class RobotState {
    private String voltage;
    private String speed;
    private String position;
}
