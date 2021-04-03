package com.huashu.monitor.dao;

import com.huashu.monitor.dto.DeviceDto;
import com.huashu.monitor.pojo.Device;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceDao {
    Device getFacilityInfo(int devTypeId);
    int updateFacility(Device device);
    int insertFacility(Device device);
    int batchInsertFacility(List<Device> devices);
    List<DeviceDto> getFacilityList(int devTypeId);

}
