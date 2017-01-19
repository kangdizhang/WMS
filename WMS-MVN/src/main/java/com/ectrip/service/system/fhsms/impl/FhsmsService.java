package com.ectrip.service.system.fhsms.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ectrip.dao.system.fhsms.FhsmsDao;
import org.springframework.stereotype.Service;
import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import com.ectrip.service.system.fhsms.FhsmsManager;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 说明： 站内信
 * 创建人：FH Q313596790
 * 创建时间：2016-01-17
 * @version
 */
@Service("fhsmsService")
@Transactional
public class FhsmsService implements FhsmsManager{

	@Resource
	private FhsmsDao dao;
	
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
		dao.delete(pd);
	}
	
	/**修改状态
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
	
	/**获取未读总数
	 * @param
	 * @throws Exception
	 */
	public PageData findFhsmsCount(String USERNAME)throws Exception{
		return dao.findFhsmsCount(USERNAME);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.deleteAll( ArrayDATA_IDS);
	}
	
}

