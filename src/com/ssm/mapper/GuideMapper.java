package com.ssm.mapper;

import java.util.List;

import com.ssm.po.Guide;

public interface GuideMapper
{
	public void addGuide(Guide guide);

	public List<Guide> findUncheckedGuide();

	public List<Guide> findCheckedGuide();

	public void checkGuide(Integer guideId);

	public Guide findGuideByGuideId(Integer guideId);

	public void setGuideRate(Guide guide);

	public void updateGuide(Guide guide);

	public void setGuideNumber(Guide guide);

	public List<Guide> selectGuideByKey(String key);

	public List<Guide> findGuideByCoachId(Integer coachId);

	public List<Guide> selectGuideByType(String type);

}
