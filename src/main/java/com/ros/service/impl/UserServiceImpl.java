package com.ros.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ros.DTO.LoginDTO;
import com.ros.domain.User;
import com.ros.service.UserService;
import com.ros.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

/**
* @author ss
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-07-02 15:59:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User doLogin(LoginDTO loginDTO) throws LoginException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        String userName = loginDTO.getUserName();
        userQueryWrapper.eq("user_name",userName);
        User user = userMapper.selectOne(userQueryWrapper);
        if(user == null) {
            throw new AccountNotFoundException();
        } else if(!user.getPassword().equals(loginDTO.getPassword())) {
            throw new FailedLoginException();
        }
        return user;
    }
}




