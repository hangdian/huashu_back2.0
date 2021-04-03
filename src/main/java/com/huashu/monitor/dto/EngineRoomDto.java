package com.huashu.monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EngineRoomDto {
    private int engineRoomId;
    private String regionId;//机房所在ID
    private String engineRoomAddress;
    private String longitude;
    private String lati;
    private String pic;
    private BigDecimal arrears;
    private Timestamp createTime;
    private Timestamp updateTime;


}
