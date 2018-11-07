package com.jeecg.zwzx.web.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.jeecg.zwzx.entity.WorkApplyEntity;
import com.jeecg.zwzx.entity.WorkInterviewEntity;
import com.jeecg.zwzx.service.WorkInterviewService;

 /**
 * 描述：预约表
 * @author: www.jeecg.org
 * @since：2018年11月07日 08时04分31秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/api/zwzx/interview")
public class ApiInterviewController extends BaseController{
  @Autowired
  private WorkInterviewService workInterviewService;
  

	@RequestMapping(value="/interviewList")
	public @ResponseBody String interviewList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String guideId = request.getParameter("guideid");
		List list =  workInterviewService.getInterviewNum(guideId);
		// 分页数据
		
		return JSONArray.toJSONString(list);
	}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void workInterviewDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "jeecg/zwzx/workInterview-detail.vm";
			WorkInterviewEntity workInterview = workInterviewService.get(id);
			velocityContext.put("workInterview",workInterview);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "jeecg/zwzx/workInterview-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(value = "/startInterview",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson startInterview(@ModelAttribute WorkInterviewEntity workInterview,HttpServletRequest request,HttpServletResponse response){
		AjaxJson j = new AjaxJson();
		String chooseTime = request.getParameter("chooseTime");
		String time = request.getParameter("date");
		if(Integer.parseInt(chooseTime)==1){
			time=time+" 10:00:00";
		}else{
			time=time+" 14:00:00";
		}
		//String—>Date
		Date date = null;
		try{
		    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    date = sdf.parse(time);
		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
		workInterview.setChoosTime(Integer.parseInt(chooseTime));
		workInterview.setInterviewDate(date);
		workInterview.setInterviewStatus(1); //预约成功
		try {
			workInterviewService.startInterview(workInterview);
			j.setMsg("保存成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("保存失败");
		    e.printStackTrace();
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 WorkInterviewEntity workInterview = workInterviewService.get(id);
			 velocityContext.put("workInterview",workInterview);
			 String viewName = "jeecg/zwzx/workInterview-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute WorkInterviewEntity workInterview){
		AjaxJson j = new AjaxJson();
		try {
			workInterviewService.update(workInterview);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("编辑失败");
		    e.printStackTrace();
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				workInterviewService.delete(id);
				j.setMsg("删除成功");
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("删除失败");
			    e.printStackTrace();
			}
			return j;
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			workInterviewService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			j.setSuccess(false);
			j.setMsg("批量删除失败");
			e.printStackTrace();
		}
		return j;
	}

}

