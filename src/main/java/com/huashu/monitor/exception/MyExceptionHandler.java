package com.huashu.monitor.exception;

import com.huashu.monitor.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    // 认证异常
    @ExceptionHandler(value = UnknownAccountException.class)
    public Map<String, String> handleException(UnknownAccountException e) {
        Map<String, String> result = new HashMap<>();
        result.put("status", String.valueOf(ResponseCode.ILLEGAL_ARGUMENT.getCode()));
        log.error(e.toString());
        result.put("msg", "用户名错误");
        return result;
    }

    // 认证异常
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Map<String, String> handleException(IncorrectCredentialsException e) {
        Map<String, String> result = new HashMap<>();
        result.put("status", String.valueOf(ResponseCode.ILLEGAL_ARGUMENT.getCode()));
        log.error(e.getMessage());
        result.put("msg", "密码错误");
        return result;
    }


    // 处理授权模块异常
    @ExceptionHandler(value = AuthorizationException.class)
    public Map<String, String> handleException(AuthorizationException e) {
        Map<String, String> result = new HashMap<>();
        result.put("status", String.valueOf(ResponseCode.LACK_PERMISSION.getCode()));
        //获取错误中括号的内容
        String message = e.getMessage();
        log.error(message);
        String msg = message.substring(message.indexOf("[") + 1, message.indexOf("]"));
        //判断是角色错误还是权限错误
        if (message.contains("role")) {
            result.put("msg", "对不起，您没有" + msg + "角色");
        } else if (message.contains("permission")) {
            result.put("msg", "对不起，您没有" + msg + "权限");
        } else {
            result.put("msg", "对不起，您的权限有误");
        }
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    public Map<String, String> handleException(Exception e) {
        Map<String, String> result = new HashMap<>();
        result.put("status", String.valueOf(ResponseCode.ERROR.getCode()));
        log.error(e.getMessage());
        result.put("msg", "异常，详情见服务器日志");
        return result;
    }
}
