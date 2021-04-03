package com.huashu.monitor.controller;

import com.huashu.monitor.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-28 20:51
 */
@Api(tags = "操作日志管理模块")
@RestController
@RequestMapping("/log/")
public class LogController {

    @ApiOperation(value = "条件查询服务端日志", notes = "参数:")
    @GetMapping("get_log")
    public ServerResponse getLog(){
        return null;
    }

}
