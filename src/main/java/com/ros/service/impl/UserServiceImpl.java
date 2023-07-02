package com.ros.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.domain.User;
import com.ros.service.UserService;
import com.ros.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ss
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




