package com.ssm.mapper;

import java.util.List;

import com.ssm.po.PaidGuide;

public interface PaidGuideMapper
{
	public void addPaidGuide(PaidGuide paidguide);

	public List<PaidGuide> findPaidGuideByUserId(Integer userId);

	public List<PaidGuide> findPaidGuideByCoachId(Integer coachId);

	public void setPaidGuideRate(PaidGuide paidguide);

	public List<PaidGuide> getRatedPaiGuide(PaidGuide paidguide);

	public Integer hasPaidGuide(PaidGuide paidguide);

	public List<PaidGuide> findPaidGuideByGuideId(Integer guideId);

	public PaidGuide findPaidGuideByUserIdAndGuideId(PaidGuide paidguide);

}
