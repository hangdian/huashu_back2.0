package com.huashu.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private  int regionId;
    private  int parentId;//父级区域
    private String regionName;//区域名称
    private TextArea longitude;//经度，数据库是longtext类型，百度有说不匹配的，需要改成Sting类型
    private TextArea lati;//纬度
    private Timestamp creatTime;
    private Timestamp updateTime;
}
