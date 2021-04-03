package com.huashu.monitor.controller;

import com.huashu.monitor.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-28 20:37
 */
@Api(tags = "单位管理模块")
@RestController
@RequestMapping("/agency/")
public class AgencyController {

    @ApiOperation(value = "分页查询单位列表", notes = "参数: ")
    @GetMapping(value = "get_agency_list")
    public ServerResponse getAgencyListTree() {
        return null;
    }


    @ApiOperation(value = "添加单位", notes = "参数: ")
    @GetMapping(value = "insert_agency")
    public ServerResponse insertAgency() {
        return null;
    }


    @ApiOperation(value = "更新单位信息", notes = "参数: ")
    @GetMapping(value = "update_agency_info")
    public ServerResponse updateAgencyInfo() {
        return null;
    }
}
