package com.ectrip.dao.weixin.command;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * 类名称：CommandDao
 * 创建人：FH QQ 313596790
 * 创建时间：2015-05-09
 */
@Service("CommandMapper")
public interface CommandDao {

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd);
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd);
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd);
	
	/**列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> datalistPage(Page page);
	
	/**列表(全部)
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd);
	
	/**通过id获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd);
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS);
	
	/**匹配关键词
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByKw(PageData pd);
}

