package com.ros.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.ros.DTO.LoginDTO;
import com.ros.domain.User;
import com.ros.result.Result;
import com.ros.result.ResultUtil;
import com.ros.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.security.auth.login.AccountException;
import javax.security.auth.login.FailedLoginException;

@RestController
@RequestMapping("/user")
@Tag(name ="用户模块相关接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "登录请求")
    @PostMapping("/login")
    public Result<Object> Login(@RequestBody LoginDTO loginDTO) {
        User user = new User();
        try {
            user = userService.doLogin(loginDTO);
        } catch (AccountException e) {
            return ResultUtil.defineFail(401, "用户名不存在");
        } catch (FailedLoginException e) {
            return ResultUtil.defineFail(402, "密码错误");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500, "服务器内部错误");
        }
        StpUtil.login(user.getId());
        return ResultUtil.success("登陆成功").setData(user.getUserRole());
    }

    @Operation(summary = "注销登录")
    @GetMapping("/logout")
    public <T> Result<T> Logout() {
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException e) {
            return ResultUtil.defineFail(403,"未登录");
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
        StpUtil.logout();
        return ResultUtil.success("注销登录成功");
    }

    @Operation(summary = "注册请求")
    @GetMapping("/register")
    public <T> Result<T> Register() {
        try {
            StpUtil.checkLogin();
        } catch (NotLoginException e) {
            log.error(e.toString());
            return ResultUtil.defineFail(500,"服务器内部错误");
        }
        StpUtil.logout();
        return ResultUtil.success("注销登录成功");
    }

    @Operation(summary = "获取用户角色")
    @GetMapping("/getUserRole")
    public Result<String> getUserRole() {
        try {
            Integer loginId = Integer.valueOf(StpUtil.getLoginId().toString());
            User user = userService.getById(loginId);
            return ResultUtil.success(user.getUserRole());
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.defineFail(405,"未登录");
        }
    }
}
