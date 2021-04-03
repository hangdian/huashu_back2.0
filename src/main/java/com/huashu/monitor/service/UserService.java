package com.huashu.monitor.service;


import com.huashu.monitor.pojo.Perms;
import com.huashu.monitor.pojo.User;

import java.util.List;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-15 22:36
 */
public interface UserService {
    // 注册用户
    void register(User user);

    // 根据用户名查询用户
    User findByUserName(String username);

    // 根据用户名查询用户角色
    User findRolesByUserName(String username);

    List<Perms> findPermsByRoleId(String id);
}
