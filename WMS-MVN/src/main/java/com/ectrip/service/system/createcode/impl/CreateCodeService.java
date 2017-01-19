package com.ectrip.service.system.createcode.impl;
import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.system.createcode.CreateCodeDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.Page;
import com.ectrip.service.system.createcode.CreateCodeManager;
import com.ectrip.util.PageData;
import org.springframework.transaction.annotation.Transactional;


/** 
 * 类名称：CreateCodeService 代码生成器
 * 创建人：FH Q313596790
 * 修改时间：2015年11月24日
 * @version
 */
@Service("createcodeService")
@Transactional
public class CreateCodeService implements CreateCodeManager{

	@Resource
	private CreateCodeDao dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save( pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete(pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return dao.datalistPage( page);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return dao.findById(pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.deleteAll(ArrayDATA_IDS);
	}
	
}

