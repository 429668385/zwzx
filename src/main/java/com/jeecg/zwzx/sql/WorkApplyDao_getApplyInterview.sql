SELECT wa.*,wi.interview_date as interview_date,wi.CHOOS_TIME as CHOOS_TIME,wi.id as interview_id FROM work_apply wa left join work_interview wi on wa.id = wi.apply_id  where 1=1 
and wa.DEAL_PERSION = :workApply.dealPersion 
and wa.APPLY_STATUS >1 and wa.APPLY_STATUS < 4 
order by wa.APPLY_DATA desc