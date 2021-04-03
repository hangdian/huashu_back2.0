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
@Api(tags = "部门管理模块")
@RestController
@RequestMapping("/dept/")
public class DeptController {

    @ApiOperation(value = "查询部门列表", notes = "参数: ")
    @GetMapping(value = "get_dept_list")
    public ServerResponse getDeptList() {
        return null;
    }

    @ApiOperation(value = "添加部门", notes = "参数: ")
    @GetMapping(value = "insert_dept")
    public ServerResponse<String> insertDept() {
        return null;
    }


    @ApiOperation(value = "更新部门信息", notes = "参数: ")
    @GetMapping(value = "update_dept_info")
    public ServerResponse<String> updateDeptInfo() {
        return null;
    }
}
