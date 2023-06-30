package com.ros.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.ros.DTO.LoginDTO;
import com.ros.domain.User;
import com.ros.result.Result;
import com.ros.result.ResultUtil;
import com.ros.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountException;
import javax.security.auth.login.FailedLoginException;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
@Tag(name ="用户模块相关接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "登录请求")
    @PostMapping("/Login")
    public Result<JSONObject> Login(@RequestBody LoginDTO loginDTO) {
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
        HashMap<String,String> map = new HashMap<>();
        map.put("UserRole",user.getUserRole());
        JSONObject jsonObject = new JSONObject(map);
        return ResultUtil.success(jsonObject);
    }


}
