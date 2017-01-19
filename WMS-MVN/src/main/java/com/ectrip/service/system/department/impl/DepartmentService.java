package com.ectrip.service.system.department.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.system.department.DepartmentDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.Page;
import com.ectrip.entity.system.Department;
import com.ectrip.util.PageData;
import com.ectrip.service.system.department.DepartmentManager;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 说明： 组织机构
 * 创建人：FH Q313596790
 * 创建时间：2015-12-16
 * @version
 */
@Service("departmentService")
@Transactional
public class DepartmentService implements DepartmentManager{

	@Resource
	private DepartmentDao dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save(pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete( pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.edit( pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return dao.datalistPage(page);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return dao.findById( pd);
	}
	
	/**通过编码获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByBianma(PageData pd)throws Exception{
		return dao.findByBianma(pd);
	}
	
	/**
	 * 通过ID获取其子级列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Department> listSubDepartmentByParentId(String parentId) throws Exception {
		return dao.listSubDepartmentByParentId(parentId);
	}
	
	/**
	 * 获取所有数据并填充每条数据的子级列表(递归处理)
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Department> listAllDepartment(String parentId) throws Exception {
		List<Department> departmentList = this.listSubDepartmentByParentId(parentId);
		for(Department depar : departmentList){
			depar.setTreeurl("department/list.do?DEPARTMENT_ID="+depar.getDEPARTMENT_ID());
			depar.setSubDepartment(this.listAllDepartment(depar.getDEPARTMENT_ID()));
			depar.setTarget("treeFrame");
		}
		return departmentList;
	}
	
}

