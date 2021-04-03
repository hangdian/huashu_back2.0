package com.huashu.monitor.service;

import com.github.pagehelper.PageInfo;
import com.huashu.monitor.dto.PageDto;
import com.huashu.monitor.pojo.Device;

import java.util.List;

public interface DeviceService {
    Device getFacilityInfo(int devTypeId);
    int updateFacility(Device device);
    int insertFacility(Device device);
    int batchInsertFacility(List<Device> devices);
    PageInfo getFacilityList(PageDto pageDto, int devTypeId);



}
