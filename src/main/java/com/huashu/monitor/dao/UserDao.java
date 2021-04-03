package com.huashu.monitor.dao;

import com.huashu.monitor.pojo.Perms;
import com.huashu.monitor.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-15 22:28
 */
@Mapper
@Component
public interface UserDao {

    void save(User user);

    User findByUserName(String username);

    // 根据用户名查询用户角色
    User findRolesByUserName(String username);

    // 根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}
