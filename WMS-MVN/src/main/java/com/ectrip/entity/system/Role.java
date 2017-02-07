package com.ectrip.entity.system;
/**
 * 
* 类名称：角色
* 类描述： 
* @author FH QQ 313596790[青苔]
* 作者单位： 
* 联系方式：
* 创建时间：2014年3月10日
* @version 1.0
 */
public class Role {
	private String ROLE_ID;    //角色id
	private String ROLE_NAME;	 //角色名称
	private String RIGHTS;	 //权限
	private String PARENT_ID; //？（父角色ID？）
	private String ADD_QX;	 //？（增权限？）
	private String DEL_QX;	 //？（删权限？）
	private String EDIT_QX;	 //？（改权限？）
	private String CHA_QX;	 //？（查权限？）
	private String UTIME;		 //操作时间
	private int STATUS;			 //角色状态（0：启用，1：停用）

	public String getROLE_ID() {
		return ROLE_ID;
	}
	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}
	public String getROLE_NAME() {
		return ROLE_NAME;
	}
	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}
	public String getRIGHTS() {
		return RIGHTS;
	}
	public void setRIGHTS(String rIGHTS) {
		RIGHTS = rIGHTS;
	}
	public String getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(String pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}
	public String getADD_QX() {
		return ADD_QX;
	}
	public void setADD_QX(String aDD_QX) {
		ADD_QX = aDD_QX;
	}
	public String getDEL_QX() {
		return DEL_QX;
	}
	public void setDEL_QX(String dEL_QX) {
		DEL_QX = dEL_QX;
	}
	public String getEDIT_QX() {
		return EDIT_QX;
	}
	public void setEDIT_QX(String eDIT_QX) {
		EDIT_QX = eDIT_QX;
	}
	public String getCHA_QX() {
		return CHA_QX;
	}
	public void setCHA_QX(String cHA_QX) {
		CHA_QX = cHA_QX;
	}

	public String getUTIME() {
		return UTIME;
	}

	public void setUTIME(String UTIME) {
		this.UTIME = UTIME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int STATUS) {
		this.STATUS = STATUS;
	}
}
