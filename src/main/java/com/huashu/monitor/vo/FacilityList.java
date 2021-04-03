package com.huashu.monitor.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Facility查询对象", description = "设备查询对象封装")
@Data
public class FacilityList {
        @ApiModelProperty(value = "设备ID")
        private int id;

        @ApiModelProperty(value = "设备名字")
        private String name;

        @ApiModelProperty(value = "设备状态")
        private String status;

        @ApiModelProperty(value = "设备所属机房")
        private String roomName;
        @ApiModelProperty(value = "设备类型")
        private String type;


}
