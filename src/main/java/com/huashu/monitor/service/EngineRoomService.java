package com.huashu.monitor.service;

import com.github.pagehelper.PageInfo;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.pojo.EngineRoom;
import com.huashu.monitor.pojo.EngineRoomTree;

import java.util.List;

public interface EngineRoomService {
    int insertRoomInfo(EngineRoom engineRoom);
    int  updateRoomList(EngineRoom engineRoom);
    EngineRoom getRoomInfo(int engineRoomId);
    PageInfo getRoomList( PageDto pageDto,int regionId);
    List<EngineRoomTree> getTreeRoomList();

}
