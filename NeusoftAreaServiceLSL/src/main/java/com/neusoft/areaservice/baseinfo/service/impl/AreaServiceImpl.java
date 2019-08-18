package com.neusoft.areaservice.baseinfo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.neusoft.areaservice.baseinfo.mapper.IAreaMapper;
import com.neusoft.areaservice.baseinfo.model.AreaModel;
import com.neusoft.areaservice.baseinfo.service.IAreaService;
/**
 *    模块：基础信息   表：小区 Area
 * 小区业务层接口的实现类
 * @Author: 吕淑兰
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private IAreaMapper areaMapper=null;
	
	//@Autowired
	//private RestTemplate rest=null;
	
	//@Value("${neusoftareaservice.url}")
	//private String url=null;
	
	@Override
	public void add(AreaModel areaModel) throws Exception {
		areaMapper.create(areaModel);

	}

	@Override
	public void modify(AreaModel areaModel) throws Exception {
		areaMapper.update(areaModel);

	}

	@Override
	public void delete(AreaModel areaModel) throws Exception {
		areaMapper.delete(areaModel);

	}

	@Override
	public List<AreaModel> getAreaListByAll() throws Exception {
		//System.out.println(url);
		//List<AreaModel> list=rest.getForObject(url+"area/list/all", List.class);
		//return list;
		return areaMapper.selectAreaListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public AreaModel getAreaByNo(int no) throws Exception {
		
		return areaMapper.selectAreaByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaModel> getListByAllWithPage(int rows, int page) throws Exception {
		return areaMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return areaMapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int getPagaCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaModel> getListByConditionWithPage(String name, String developer, BigDecimal minbuildingarea,
			BigDecimal maxbuildingarea, int minhome, int maxhome, int minhouse, int maxhouse, int rows, int page)
			throws Exception {
		
		if(name!=null&&name.trim().length()>0) {
			name="%"+name+"%";
		}
		if(developer!=null&&developer.trim().length()>0) {
			developer="%"+developer+"%";
		}
		return areaMapper.selectListByConditionWithPage(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse, rows*(page-1), rows);
	}

	@Override
	public int getCountByCondition(String name, String developer, BigDecimal minbuildingarea, BigDecimal maxbuildingarea,
			int minhome, int maxhome, int minhouse, int maxhouse) throws Exception {
		return areaMapper.selectCountByCondition(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse);
	}

	@Override
	public int getPageCountByConditionWithPage(String name, String developer,
			BigDecimal minbuildingarea, BigDecimal maxbuildingarea, int minhome, int maxhome, int minhouse,
			int maxhouse, int rows) throws Exception {

		int pageCount=0;
		int count=this.getCountByCondition(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<AreaModel> getListByDeveloper() throws Exception {
		return areaMapper.selectListByDeveloper();
	}


	
	
}
