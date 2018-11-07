package com.jeecg.zwzx.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.jeecg.zwzx.dao.WorkInterviewDao;
import com.jeecg.zwzx.entity.WorkInterviewEntity;
import com.jeecg.zwzx.service.WorkInterviewService;

/**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三 
 * @version:1.0
 */

@Service("workInterviewService")
public class WorkInterviewServiceImpl implements WorkInterviewService {
	@Resource
	private WorkInterviewDao workInterviewDao;

	@Override
	public WorkInterviewEntity get(String id) {
		return workInterviewDao.get(id);
	}

	@Override
	public int update(WorkInterviewEntity workInterview) {
		return workInterviewDao.update(workInterview);
	}

	@Override
	public void insert(WorkInterviewEntity workInterview) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		workInterview.setId(randomSeed);
		workInterviewDao.insert(workInterview);
		
	}

	@Override
	public MiniDaoPage<WorkInterviewEntity> getAll(WorkInterviewEntity workInterview, int page, int rows) {
		return workInterviewDao.getAll(workInterview, page, rows);
	}

	@Override
	public void delete(String id) {
		workInterviewDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			workInterviewDao.deleteById(id);
		}
	}
}
