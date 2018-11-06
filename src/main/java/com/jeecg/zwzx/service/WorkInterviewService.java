package com.jeecg.zwzx.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.jeecg.zwzx.entity.WorkInterviewEntity;

/**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月06日 07时09分10秒 星期二 
 * @version:1.0
 */
public interface WorkInterviewService {
	public WorkInterviewEntity get(String id);

	public int update(WorkInterviewEntity workInterview);

	public void insert(WorkInterviewEntity workInterview);

	public MiniDaoPage<WorkInterviewEntity> getAll(WorkInterviewEntity workInterview,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
