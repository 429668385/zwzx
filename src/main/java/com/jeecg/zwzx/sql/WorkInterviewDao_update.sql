UPDATE work_interview
SET 
	   <#if workInterview.id ?exists>
		   ID = :workInterview.id,
		</#if>
	   <#if workInterview.applyId ?exists>
		   APPLY_ID = :workInterview.applyId,
		</#if>
	   <#if workInterview.interviewStatus ?exists>
		   INTERVIEW_STATUS = :workInterview.interviewStatus,
		</#if>
	    <#if workInterview.interviewDate ?exists>
		   INTERVIEW_DATE = :workInterview.interviewDate,
		</#if>
	    <#if workInterview.dealDate ?exists>
		   DEAL_DATE = :workInterview.dealDate,
		</#if>
	   <#if workInterview.dealPersion ?exists>
		   DEAL_PERSION = :workInterview.dealPersion,
		</#if>
	   <#if workInterview.audit ?exists>
		   AUDIT = :workInterview.audit,
		</#if>
	   <#if workInterview.reply ?exists>
		   REPLY = :workInterview.reply,
		</#if>
WHERE id = :workInterview.id