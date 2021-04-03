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
 * @create 2021-03-28 19:08
 */
@Api(tags = "告警管理模块")
@RestController
@RequestMapping("/warning/")
@Slf4j
public class WarningController {

    @ApiOperation(value = "修改告警事件", notes = "参数:")
    @GetMapping("update_warning_record")
    public ServerResponse updateWarningRecord(){
        return null;
    }


    @ApiOperation(value = "按条件分页查询告警事件列表", notes = "参数:")
    @GetMapping("get_warning_record_list")
    public ServerResponse getWarningRecordList(){
        return null;
    }


    @ApiOperation(value = "按条件查询历史告警数据", notes = "参数:")
    @GetMapping("get_warning_history_data")
    public ServerResponse getWarningHistoryData(){
        return null;
    }

}
