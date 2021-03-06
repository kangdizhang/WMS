package com.ectrip.service.system.buttonrights.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.system.buttonrights.ButtonrightsDao;
import org.springframework.stereotype.Service;

import com.ectrip.util.PageData;
import com.ectrip.service.system.buttonrights.ButtonrightsManager;
import org.springframework.transaction.annotation.Transactional;

/** 
 * 说明： 按钮权限
 * 创建人：FH Q313596790
 * 创建时间：2016-01-16
 * @version
 */
@Service("buttonrightsService")
@Transactional
public class ButtonrightsService implements ButtonrightsManager{

	@Resource
	private ButtonrightsDao dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save( pd);
	}
	
	/**通过(角色ID和按钮ID)获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd) throws Exception {
		return dao.findById(pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete(pd);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return dao.listAll( pd);
	}
	
	/**列表(全部)左连接按钮表,查出安全权限标识
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllBrAndQxname(PageData pd)throws Exception{
		return dao.listAllBrAndQxname(pd);
	}

}

