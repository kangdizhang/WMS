package com.ectrip.service.weixin.imgmsg;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.weixin.imgmsg.ImgmsgDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.Page;
import com.ectrip.util.PageData;
import org.springframework.transaction.annotation.Transactional;


/** 
 * 类名称：ImgmsgDao
 * 创建人：FH QQ 313596790
 * 创建时间：2015-05-09
 */
@Service("imgmsgService")
@Transactional
public class ImgmsgService {

	@Resource
	private ImgmsgDao dao;
	
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
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.edit(pd);
	}
	
	/**列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return dao.datalistPage(page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return dao.listAll( pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @return
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
	
	/**匹配关键词
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByKw(PageData pd)throws Exception{
		return dao.findByKw( pd);
	}
}

