package com.huashu.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineRoomTree {
    private int engineRoomId;
    private String regionId;//机房所在ID
    private int devTypeId;//类型ID
}
