package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.Robot;
import com.ros.service.RobotService;
import com.ros.mapper.RobotMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【robot】的数据库操作Service实现
* @createDate 2023-06-30 13:19:42
*/
@Service
public class RobotServiceImpl extends ServiceImpl<RobotMapper, Robot>
    implements RobotService{

}




