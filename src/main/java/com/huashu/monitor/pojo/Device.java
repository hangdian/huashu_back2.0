package com.huashu.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    private int devId;
    private int devTypeId;//类型
    private String userId;
    private String devEui;
    private String oidiIndex;
    private String computerRoomId;//所属机房
    private String tmnAddr;
    private String longitude;
    private String lati;
    private String coordType;
    private String position;
    private Timestamp createTime;
    private Timestamp updateTime;
}
