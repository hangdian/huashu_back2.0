package com.huashu.monitor.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.monitor.dao.DeviceDao;
import com.huashu.monitor.dto.DeviceDto;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.pojo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceDao deviceDao;
    @Override
    public Device getFacilityInfo(int devTypeId) {
        return deviceDao.getFacilityInfo(devTypeId);
    }

    @Override
    public int updateFacility(Device device) {
        return deviceDao.updateFacility(device);
    }

    @Override
    public int insertFacility(Device device) {
        return deviceDao.insertFacility(device);
    }

    @Override
    public int batchInsertFacility(List<Device> devices) {
        return deviceDao.batchInsertFacility(devices);
    }

    @Override
    public PageInfo getFacilityList(PageDto pageDto, int devTypeId) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        List<DeviceDto> devices = deviceDao.getFacilityList(devTypeId);
        PageInfo<DeviceDto> deviceDtoPageInfo = new PageInfo<>(devices);
        return deviceDtoPageInfo;
    }

}
