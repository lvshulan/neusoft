package com.neusoft.areaservice.baseinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 *    模块：基础信息   表：小区 Area
 *    小区的Model类
 * @Author: 吕淑兰
 */
@Alias("area")
@Data
public class AreaModel implements Serializable {
	private int no=0; //小区编号
	private String name=null; //小区名称
	private String address=null; //小区地址
	private String developer=null; //开发商
	private BigDecimal buildingarea=null; //总建筑面积
	private BigDecimal usearea=null; //总使用面积
	private BigDecimal parkarea=null; //车位面积
	private int home=0; //总居民数
	private int house=0; //总公建数
	private int park=0; //车位数
}
