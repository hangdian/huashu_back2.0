package com.huashu.monitor.dao;

import com.huashu.monitor.dto.EngineRoomDto;
import com.huashu.monitor.pojo.EngineRoom;
import com.huashu.monitor.pojo.EngineRoomTree;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EngineRoomDao {
    int insertRoomInfo(EngineRoom engineRoom);
    int  updateRoomList(EngineRoom engineRoom);
    EngineRoom getRoomInfo(int engineRoomId);
    List<EngineRoomDto> getRoomList(int regionId);
    List<EngineRoomTree> getTreeRoomList();




}
