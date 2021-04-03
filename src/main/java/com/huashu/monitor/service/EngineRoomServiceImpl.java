package com.huashu.monitor.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.monitor.dao.EngineRoomDao;
import com.huashu.monitor.dto.EngineRoomDto;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.pojo.EngineRoom;
import com.huashu.monitor.pojo.EngineRoomTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EngineRoomServiceImpl implements EngineRoomService{
    @Autowired
    EngineRoomDao engineRoomDao;
    @Override
    public int insertRoomInfo(EngineRoom engineRoom) {
        return engineRoomDao.insertRoomInfo(engineRoom);
    }

    @Override
    public int updateRoomList(EngineRoom engineRoom) {
        return engineRoomDao.updateRoomList(engineRoom);
    }

    @Override
    public EngineRoom getRoomInfo(int engineRoomId) {
        return engineRoomDao.getRoomInfo(engineRoomId);
    }

    @Override
    public PageInfo getRoomList(PageDto pageDto, int regionId) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<EngineRoomDto> engineRoomList= engineRoomDao.getRoomList(regionId);
        PageInfo<EngineRoomDto> engineRoomDtoPageInfo = new PageInfo<>(engineRoomList);
        return engineRoomDtoPageInfo;
    }

    @Override
    public List<EngineRoomTree> getTreeRoomList() {
        return engineRoomDao.getTreeRoomList();
    }
}
