package com.ectrip.service.system.role.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ectrip.dao.system.role.RoleDao;
import org.springframework.stereotype.Service;

import com.ectrip.entity.system.Role;
import com.ectrip.service.system.role.RoleManager;
import com.ectrip.util.PageData;
import org.springframework.transaction.annotation.Transactional;

/**	角色
 * @author FHadmin QQ313596790
 * 修改日期：2015.11.6
 */
@Service("roleService")
@Transactional
public class RoleService implements RoleManager{

	@Resource
	private RoleDao dao;
	
	/**列出此组下级角色
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Role> listAllRolesByPId(PageData pd) throws Exception {
		return  dao.listAllRolesByPId(pd);
	}
	
	/**通过id查找
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findObjectById(PageData pd) throws Exception {
		return (PageData)dao.findObjectById( pd);
	}
	
	/**添加
	 * @param pd
	 * @throws Exception
	 */
	public void add(PageData pd) throws Exception {
		dao.insert(pd);
	}
	
	/**保存修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd) throws Exception {
		dao.edit( pd);
	}
	
	/**删除角色
	 * @param ROLE_ID
	 * @throws Exception
	 */
	public void deleteRoleById(String ROLE_ID) throws Exception {
		dao.deleteRoleById(ROLE_ID);
	}
	
	/**给当前角色附加菜单权限
	 * @param role
	 * @throws Exception
	 */
	public void updateRoleRights(Role role) throws Exception {
		dao.updateRoleRights( role);
	}
	
	/**通过id查找
	 * @param
	 * @return
	 * @throws Exception
	 */
	public Role getRoleById(String ROLE_ID) throws Exception {
		return dao.getRoleById( ROLE_ID);
	}
	
	/**给全部子角色加菜单权限
	 * @param pd
	 * @throws Exception
	 */
	public void setAllRights(PageData pd) throws Exception {
		dao.setAllRights(pd);
	}
	
	/**权限(增删改查)
	 * @param msg 区分增删改查
	 * @param pd
	 * @throws Exception
	 */
	public void saveB4Button(String msg,PageData pd) throws Exception {
		if(msg.equals("")){

		}
		dao.saveB4Button("RoleMapper."+msg, pd);
	}

}
