package com.neusoft.areaservice.baseinfo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.areaservice.baseinfo.model.AreaModel;

/**
 *   模块：基础信息   表：小区 Area
 *  小区业务层接口
 * @Author:吕淑兰
 */

public interface IAreaService {
	//添加
	public void add(AreaModel areaModel) throws Exception;
	//修改
	public void modify(AreaModel areaModel) throws Exception;
	//修改
	public void delete(AreaModel areaModel) throws Exception;
	//查询小区的信息
	public List<AreaModel> getAreaListByAll() throws Exception;
	//取得指定小区的信息
	public AreaModel getAreaByNo(int no) throws Exception;
	
	//取得所有小区列表,分页模式
	public List<AreaModel> getListByAllWithPage(int rows,int page) throws Exception;
	//取得小区的个数
	public int getCountByAll() throws Exception;
	//取得小区页数
	public int getPagaCountByAll(int rows) throws Exception;
	//取得开发商列表
	public List<AreaModel> getListByDeveloper() throws Exception;
	//根据综合检索条件取得小区列表
	public List<AreaModel> getListByConditionWithPage(String name,String developer,BigDecimal minbuildingarea,BigDecimal maxbuildingarea,
			int minhome,int maxhome,int minhouse,int maxhouse, int rows,int page) throws Exception;
	
	//根据综合检索条件取得小区个数
	public int getCountByCondition(String name,String developer,BigDecimal minbuildingarea,BigDecimal maxbuildingarea,int minhome,
			int maxhome,int minhouse,int maxhouse) throws Exception;
	
	//根据综合检索条件取得小区显示的页数
	public int getPageCountByConditionWithPage(String name,String developer,BigDecimal minbuildingarea,BigDecimal maxbuildingarea,
			int minhome,int maxhome,int minhouse,int maxhouse,int rows) throws Exception;

}
