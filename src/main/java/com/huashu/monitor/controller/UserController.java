package com.huashu.monitor.controller;

import com.huashu.monitor.common.ServerResponse;
import com.huashu.monitor.pojo.User;
import com.huashu.monitor.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-26 13:49
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @GetMapping("register")
    @ApiOperation(value = "用户注册", notes = "参数: ")
    public ServerResponse<String> register(User user) {
        userService.register(user);
        return ServerResponse.createBySuccessMessage("注册成功");

    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("logout")
    @ApiOperation(value = "用户登出", notes = "参数: ")
    public ServerResponse<String> logout() {
        SecurityUtils.getSubject().logout();
        return ServerResponse.createBySuccessMessage("退出登录成功");
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("login")
    @ApiOperation(value = "用户登录", notes = "参数: ")
    public ServerResponse<String> login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        subject.login(token);
        return ServerResponse.createBySuccess("登录成功", "data");
    }


    @ApiOperation(value = "更新用户信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "update_user_info")
    public ServerResponse updateUserInfo() {
        return null;
    }


    @ApiOperation(value = "获取当前登录用户信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_user_info")
    public ServerResponse getUserInfo() {
        return null;
    }

    @ApiOperation(value = "按类型分页查询用户列表", notes = "参数:")
    @RequiresRoles("admin")
    @GetMapping(value = "get_user_list")
    public ServerResponse getUserList() {
        return null;
    }

    @ApiOperation(value = "批量添加用户", notes = "参数:")
    @RequiresRoles("admin")
    @GetMapping(value = "batch_insert_user")
    public ServerResponse batchInsertUser() {
        return null;
    }

    @ApiOperation(value = "添加用户", notes = "参数:")
    @RequiresRoles("admin")
    @GetMapping(value = "insert_user")
    public ServerResponse insertUser() {
        return null;
    }


//    @GetMapping("index")
//    @RequiresRoles("admin")
//    @ApiOperation(value = "测试用户权限", notes = "参数: null")
//    public ServerResponse<String> testUserRoles() {
//        return ServerResponse.createBySuccess("有权限", "data");
//    }


}
