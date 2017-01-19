package com.ectrip.dao.system.createcode;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
 * 类名称：代码生成器接口类
 * 创建人：FH Q313596790
 * 修改时间：2015年11月24日
 * @version
 */
@Repository("CreateCodeMapper")
public interface CreateCodeDao {
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> datalistPage(Page page)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
}
