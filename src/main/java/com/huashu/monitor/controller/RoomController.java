package com.huashu.monitor.controller;

import com.huashu.monitor.common.ServerResponse;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.pojo.EngineRoom;
import com.huashu.monitor.service.EngineRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther supermao
 * @create 2021-03-28 20:16
 */
@Api(tags = "机房管理模块")
@RestController
@RequestMapping("/room/")
@Slf4j
public class RoomController {
    @Autowired
    EngineRoomService engineRoomService;
    @ApiOperation(value = "添加机房", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "insert_room")
    public ServerResponse insertRoomInfo(EngineRoom engineRoom) {
        return ServerResponse.createBySuccess("添加成功",engineRoomService.insertRoomInfo(engineRoom));
    }
    @ApiOperation(value = "更新机房信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "update_room")
    public ServerResponse updateRoomList(EngineRoom engineRoom) {
        return ServerResponse.createBySuccess("更新成功",engineRoomService.updateRoomList(engineRoom));
    }


    @ApiOperation(value = "查询指定机房信息", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_room_info")
    public ServerResponse getRoomInfo(int engineRoomId) {
        return ServerResponse.createBySuccess("查询成功",engineRoomService.getRoomInfo(engineRoomId));
    }


    @ApiOperation(value = "按类型分页查询机房列表", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_room_list")
    public ServerResponse getRoomList(PageDto pageDto, int regionId) {
        return ServerResponse.createBySuccess("分页查询",engineRoomService.getRoomList(pageDto,regionId));
    }


    @ApiOperation(value = "树状查询所有机房列表", notes = "参数:")
    @RequiresRoles("user")
    @GetMapping(value = "get_tree_room_list")
    public ServerResponse getTreeRoomList() {
        return ServerResponse.createBySuccess("树状查询所有机房列表",engineRoomService.getTreeRoomList());
    }


}
