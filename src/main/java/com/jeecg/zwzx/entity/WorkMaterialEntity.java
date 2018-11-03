package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：材料表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时48分47秒 星期日 
 * @version:1.0
 */
public class WorkMaterialEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 *指南名称
	 */
	private String guideName;
	public String getId() {
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
}
