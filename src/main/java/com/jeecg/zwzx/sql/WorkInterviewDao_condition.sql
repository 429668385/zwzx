		<#if ( workInterview.id )?? && workInterview.id ?length gt 0>
		    /* id */
			and wi.ID = :workInterview.id
		</#if>
		<#if ( workInterview.applyId )?? && workInterview.applyId ?length gt 0>
		    /* 申报编号 */
			and wi.APPLY_ID = :workInterview.applyId
		</#if>
		<#if ( workInterview.interviewStatus )?? && workInterview.interviewStatus ?length gt 0>
		    /* 预约状态 */
			and wi.INTERVIEW_STATUS = :workInterview.interviewStatus
		</#if>
	    <#if ( workInterview.interviewDate )??>
		    /* 预约日期  */
			and wi.INTERVIEW_DATE = :workInterview.interviewDate
		</#if>
	    <#if ( workInterview.dealDate )??>
		    /* 办理日期 */
			and wi.DEAL_DATE = :workInterview.dealDate
		</#if>
		<#if ( workInterview.dealPersion )?? && workInterview.dealPersion ?length gt 0>
		    /* 办理人员 */
			and wi.DEAL_PERSION = :workInterview.dealPersion
		</#if>
		<#if ( workInterview.audit )?? && workInterview.audit ?length gt 0>
		    /* 审核人  */
			and wi.AUDIT = :workInterview.audit
		</#if>
		<#if ( workInterview.reply )?? && workInterview.reply ?length gt 0>
		    /* 回复 */
			and wi.REPLY = :workInterview.reply
		</#if>
