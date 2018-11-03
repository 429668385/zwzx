package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：申报表
 * @author: www.jeecg.org
 * @since：2018年10月05日 13时32分21秒 星期五 
 * @version:1.0
 */
public class WorkApplyEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String guideName;
	/**
	 * 上传材料
	 */
	private String material;
	
	private String processInstanceId;
	
	private String deptLeaderPass;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getDeptLeaderPass() {
		return deptLeaderPass;
	}
	public void setDeptLeaderPass(String deptLeaderPass) {
		this.deptLeaderPass = deptLeaderPass;
	}
}
