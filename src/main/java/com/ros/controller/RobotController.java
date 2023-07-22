package com.ros.controller;

import com.ros.VO.RobotState;
import com.ros.result.Result;
import com.ros.result.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
@Tag(name = "小车信息模块")
public class RobotController {
    @GetMapping("/getRobotState")
    @Operation(summary = "获取小车信息")
    public Result<RobotState> getRobotState() {
        RobotState robotState = new RobotState();
        robotState.setConnectionStatus(Boolean.TRUE);
        robotState.setVoltage("85");
        robotState.setSpeed("1");
        return ResultUtil.success(robotState);
    }
}
