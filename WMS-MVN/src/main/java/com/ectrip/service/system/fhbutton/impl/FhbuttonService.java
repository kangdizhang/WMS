package com.ectrip.service.system.fhbutton.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ectrip.dao.system.fhbutton.FhbuttonDao;
import org.springframework.stereotype.Service;
import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import com.ectrip.service.system.fhbutton.FhbuttonManager;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 说明： 按钮管理 
 * 创建人：FH Q313596790
 * 创建时间：2016-01-15
 * @version
 */
@Service("fhbuttonService")
@Transactional
public class FhbuttonService implements FhbuttonManager{

	@Resource
	private FhbuttonDao dao;
	
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
		dao.delete( pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.edit(pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return dao.datalistPage(page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return dao.listAll(pd);
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
		dao.deleteAll( ArrayDATA_IDS);
	}
	
}

