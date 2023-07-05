package com.ros.mapper;

import com.ros.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ss
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-02 15:59:40
* @Entity com.ros.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




