package com.ectrip.service.system.appuser.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.system.appuser.AppuserDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.Page;
import com.ectrip.service.system.appuser.AppuserManager;
import com.ectrip.util.PageData;
import org.springframework.transaction.annotation.Transactional;


/**类名称：AppuserService
 * @author FH Q313596790
 * 修改时间：2015年11月6日
 */
@Service("appuserService")
@Transactional
public class AppuserService implements AppuserManager{

	@Resource
	private AppuserDao dao;
	
	/**列出某角色下的所有会员
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllAppuserByRorlid(PageData pd) throws Exception {
		return dao.listAllAppuserByRorlid(pd);
	}
	
	/**会员列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listPdPageUser(Page page)throws Exception{
		return dao.userlistPage(page);
	}
	
	/**通过用户名获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUsername(PageData pd)throws Exception{
		return dao.findByUsername(pd);
	}
	
	/**通过邮箱获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByEmail(PageData pd)throws Exception{
		return dao.findByEmail(pd);
	}
	
	/**通过编号获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByNumber(PageData pd)throws Exception{
		return dao.findByNumber(pd);
	}
	
	/**保存用户
	 * @param pd
	 * @throws Exception
	 */
	public void saveU(PageData pd)throws Exception{
		dao.saveU(pd);
	}
	
	/**删除用户
	 * @param pd
	 * @throws Exception
	 */
	public void deleteU(PageData pd)throws Exception{
		dao.deleteU( pd);
	}
	
	/**修改用户
	 * @param pd
	 * @throws Exception
	 */
	public void editU(PageData pd)throws Exception{
		dao.editU(pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByUiId(PageData pd)throws Exception{
		return dao.findByUiId( pd);
	}
	
	/**全部会员
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllUser(PageData pd)throws Exception{
		return  dao.listAllUser( pd);
	}
	
	/**批量删除用户
	 * @param USER_IDS
	 * @throws Exception
	 */
	public void deleteAllU(String[] USER_IDS)throws Exception{
		dao.deleteAllU( USER_IDS);
	}
	
	/**获取总数
	 * @param pd
	 * @throws Exception
	 */
	public PageData getAppUserCount(String value)throws Exception{
		return dao.getAppUserCount(value);
	}
	
}

