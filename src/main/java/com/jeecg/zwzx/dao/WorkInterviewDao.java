package com.jeecg.zwzx.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.jeecg.zwzx.entity.WorkInterviewEntity;

/**
 * 描述：预约表
 * @author：www.jeecg.org
 * @since：2018年11月06日 07时09分10秒 星期二 
 * @version:1.0
 */
@Repository
public interface WorkInterviewDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM work_interview WHERE ID = :id")
	WorkInterviewEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param workInterview
	 * @return
	 */
	int update(@Param("workInterview") WorkInterviewEntity workInterview);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("workInterview") WorkInterviewEntity workInterview);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param workInterview
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(WorkInterviewEntity.class)
	public MiniDaoPage<WorkInterviewEntity> getAll(@Param("workInterview") WorkInterviewEntity workInterview,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from work_interview WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from work_interview WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

