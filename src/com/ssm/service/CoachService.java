package com.ssm.service;

import java.util.List;

import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;

public interface CoachService
{

	public void coachRegist(Coach coach);

	public boolean hasCoach(String coachUsername);

	public Coach selectCoachByUserNameAndPassword(Coach coach);

	public void addGuide(Guide guide);

	public Coach getCoachByCoachId(Integer coachId);

	public void updateCoachMoney(Coach coach);

	public List<PaidGuide> findPaidGuideByCoachId(Integer coachId);

	public void updateCoachInfomation(Coach coach);

	public List<Guide> findGuideByCoachId(Integer coachId);

	public Guide findGuideByGuideId(Integer guideId);

	public void updateGuide(Guide guide);
}
