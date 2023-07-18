package com.ros.VO;

import lombok.Data;

@Data
public class RobotState {
    private Boolean connectionStatus;
    private String voltage;
    private String speed;
    private String position;
}
