package com.neusoft.areaservice.baseinfo.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.areaservice.baseinfo.model.AreaModel;

/**
 *  模块：基础信息   表：小区 Area
 * 小区的DAO层MyBatis Mapper接口
 * @Author: 吕淑兰
 */

@Mapper
public interface IAreaMapper {
	//增加小区
	public void create(AreaModel areaModel) throws Exception;
	//修改小区
	public void update(AreaModel areaModel) throws Exception;
	//删除小区
	public void delete(AreaModel areaModel) throws Exception;
	//查询小区的信息
	public List<AreaModel> selectAreaListByAll() throws Exception;
	//取得指定小区的信息
	public AreaModel selectAreaByNo(int no) throws Exception;
	//取得所有小区列表,分页模式
	public List<AreaModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得小区的个数
	public int selectCountByAll() throws Exception;
	//取得开发商列表
	public List<AreaModel> selectListByDeveloper() throws Exception;
	//根据综合检索条件取得小区列表
	public List<AreaModel> selectListByConditionWithPage(
			@Param("name") String name,
			@Param("developer") String developer,
			@Param("minbuildingarea") BigDecimal minbuildingarea,
			@Param("maxbuildingarea") BigDecimal maxbuildingarea,
			@Param("minhome") int minhome,
			@Param("maxhome") int maxhome,
			@Param("minhouse") int minhouse,
			@Param("maxhouse") int maxhouse, 
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得小区个数
	public int selectCountByCondition(
			@Param("name") String name,
			@Param("developer") String developer,
			@Param("minbuildingarea") BigDecimal minbuildingarea,
			@Param("maxbuildingarea") BigDecimal maxbuildingarea,
			@Param("minhome") int minhome,
			@Param("maxhome") int maxhome,
			@Param("minhouse") int minhouse,
			@Param("maxhouse") int maxhouse) throws Exception;
}