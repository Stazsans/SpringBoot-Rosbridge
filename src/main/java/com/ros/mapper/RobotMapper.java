package com.ros.mapper;

import com.ros.domain.Robot;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ss
* @description 针对表【robot】的数据库操作Mapper
* @createDate 2023-06-30 13:19:42
* @Entity com.ros.domain.Robot
*/
@Mapper
public interface RobotMapper extends BaseMapper<Robot> {

}




