package com.ros.service;

import com.ros.DTO.LoginDTO;
import com.ros.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.security.auth.login.AccountNotFoundException;

/**
* @author ss
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-30 13:19:42
*/
public interface UserService extends IService<User> {
    User doLogin(LoginDTO loginDTO) throws Exception;
}
