package com.huashu.monitor.controller;

import com.huashu.monitor.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-28 20:50
 */
@Api(tags = "系统参数配置模块")
@RestController
@RequestMapping("/config/")
@Slf4j
public class SystemConfigController {

    @ApiOperation(value = "设置指定类型设备告警阈值", notes = "参数:")
    @GetMapping("update_warning_threshold")
    public ServerResponse updateWarningThreshold(){
        return null;
    }


}
