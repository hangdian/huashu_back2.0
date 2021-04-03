package com.huashu.monitor.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.monitor.common.ServerResponse;
import com.huashu.monitor.pojo.Device;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-28 20:20
 */
@Api(tags = "设备管理模块")
@RestController
@RequestMapping("/facility/")
@Slf4j
public class FacilityController {
    @Autowired
    DeviceService deviceService;

    @ApiOperation(value = "查询指定设备详细信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_facility_info")
    public ServerResponse getFacilityInfo(int devTypeId) {
        //Facility facility=facilityService.getFacilityInfo(name);
        return ServerResponse.createBySuccess("查询指定设备详细信息成功",deviceService.getFacilityInfo(devTypeId));
    }


    @ApiOperation(value = "按类型分页查询设备列表设备列表", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_facility_list")
    public ServerResponse<PageInfo> getFacilityList( PageDto pageDto,int devTypeId) {
        //ServerResponse<PageInfo> serverResponse=new ServerResponse<>();
//        serverResponse.setStatus(100);
//        serverResponse.setMsg("查询分页成功");
//        serverResponse.setData(facilityService.getFacilityList(pageDto,type));
        return ServerResponse.createBySuccess("查询分页成功",deviceService.getFacilityList(pageDto,devTypeId));
    }


    @ApiOperation(value = "更新设备信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "update_room")
    public ServerResponse updateFacility(Device device) {
        //facilityService.updateFacility(facility);
        return ServerResponse.createBySuccess("更新设备信息成功",deviceService.updateFacility(device));
    }


    @ApiOperation(value = "添加设备", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "insert_facility")
    public ServerResponse insertFacility(Device device) {
        //deviceService.insertFacility(device);
        return ServerResponse.createBySuccess("添加设备成功",deviceService.insertFacility(device));
    }


    @ApiOperation(value = "批量添加设备", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "batch_insert_facility")
    public ServerResponse batchInsertFacility(List<Device> devices) {
        //facilityService.batchInsertFacility(facilities);
        return ServerResponse.createBySuccess("批量添加设备成功",deviceService.batchInsertFacility(devices));
    }


}
