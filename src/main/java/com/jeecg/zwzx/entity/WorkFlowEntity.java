package com.jeecg.zwzx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：流程表
 * @author: www.jeecg.org
 * @since：2018年09月09日 16时50分22秒 星期日 
 * @version:1.0
 */
public class WorkFlowEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 *指南名称   非字段
	 */
	private String guideName;
	
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
}
