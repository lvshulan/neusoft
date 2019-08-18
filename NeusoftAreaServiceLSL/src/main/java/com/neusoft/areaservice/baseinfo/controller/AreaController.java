package com.neusoft.areaservice.baseinfo.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.areaservice.baseinfo.model.AreaModel;
import com.neusoft.areaservice.baseinfo.service.IAreaService;
import com.neusoft.areaservice.message.ResultMessage;
/**
 *    模块：baseinfo 基础信息  
 *    小区控制层Controller
 * @Author: 吕淑兰
 */

@RestController
@RequestMapping(value="/area")
public class AreaController {
	@Autowired
	private IAreaService areas=null;
	
	//增加小区
	@PostMapping(value="/add")
	public ResultMessage<AreaModel> add(AreaModel areaModel) throws Exception {
		areas.add(areaModel);
		return new ResultMessage<AreaModel>("OK","增加小区成功");
	}
	//修改小区
	@PostMapping(value="/modify")
	public ResultMessage<AreaModel> update(AreaModel areaModel) throws Exception {
		areas.modify(areaModel);
		return new ResultMessage<AreaModel>("OK","修改小区成功");
	}
	//删除小区
	@PostMapping(value="/delete")
	public ResultMessage<AreaModel> delete(AreaModel areaModel) throws Exception {
		areas.delete(areaModel);
		return new ResultMessage<AreaModel>("OK","删除小区成功");
	}

	//取得指定的小区
	@GetMapping("/get")
	public ResultMessage<AreaModel> getByNo(int no) throws Exception{
		ResultMessage<AreaModel> result=new ResultMessage<AreaModel>("OK","取得小区成功");
		result.setModel(areas.getAreaByNo(no));
		return result;
	}
	//取得开发商列表
	@GetMapping("/list/developer")
	public List<AreaModel> getListByDeveloper() throws Exception {
		return areas.getListByDeveloper();
	}
	
	//取得所有小区列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<AreaModel> getListByAllWitPage(
			@RequestParam(required = false,defaultValue ="10") int rows,
			@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<AreaModel> result=new ResultMessage<AreaModel>("OK","取得小区列表分页模式成功");
		result.setCount(areas.getCountByAll());
		result.setPageCount(areas.getPagaCountByAll(rows));
		result.setList(areas.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有小区列表
	@GetMapping(value="/list/all")
	public List<AreaModel> getAreaListByAll() throws Exception{
		return areas.getAreaListByAll();
	}
	
	//按检索条件取得小区列表
	@GetMapping(value="/list/condition/page")
	public ResultMessage<AreaModel> getListByConditionWithPage(
			@RequestParam(required = false,defaultValue ="") String name,
			@RequestParam(required = false,defaultValue ="") String developer,
			@RequestParam(required = false,defaultValue ="") BigDecimal minbuildingarea,
			@RequestParam(required = false,defaultValue ="") BigDecimal maxbuildingarea,
			@RequestParam(required = false,defaultValue ="0") int minhome,
			@RequestParam(required = false,defaultValue ="0") int maxhome,
			@RequestParam(required = false,defaultValue ="0") int minhouse,
			@RequestParam(required = false,defaultValue ="0") int maxhouse, 
			@RequestParam(required = false,defaultValue ="5") int rows,
			@RequestParam(required = false,defaultValue ="1") int page) throws Exception {
	
		ResultMessage<AreaModel> result=new ResultMessage<AreaModel>("OK","取得小区列表分页成功");
		result.setCount(areas.getCountByCondition(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse));
		result.setPageCount(areas.getPageCountByConditionWithPage(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse, rows));
		result.setList(areas.getListByConditionWithPage(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse, rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}

}
