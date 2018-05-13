package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.CoachMapper;
import com.ssm.mapper.GuideMapper;
import com.ssm.mapper.PaidGuideMapper;
import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;
import com.ssm.service.CoachService;

public class CoachServiceImpl implements CoachService
{

	@Autowired
	private CoachMapper coachMapper;
	@Autowired
	private GuideMapper guideMapper;
	@Autowired
	private PaidGuideMapper paidGuideMapper;

	@Override
	public void coachRegist(Coach coach)
	{
		coachMapper.addCoach(coach);
	}

	@Override
	public boolean hasCoach(String coachCoachname)
	{
		int i = coachMapper.hasCoach(coachCoachname);
		if (i == 1)
			return true;
		else
			return false;
	}

	@Override
	public Coach selectCoachByUserNameAndPassword(Coach coach)
	{
		return coachMapper.selectCoachByUserNameAndPassword(coach);
	}

	@Override
	public void addGuide(Guide guide)
	{
		guideMapper.addGuide(guide);
	}

	@Override
	public Coach getCoachByCoachId(Integer coachId)
	{
		return coachMapper.getCoachByCoachId(coachId);
	}

	@Override
	public void updateCoachMoney(Coach coach)
	{
		coachMapper.updateCoachMoney(coach);
	}

	@Override
	public List<PaidGuide> findPaidGuideByCoachId(Integer coachId)
	{
		return paidGuideMapper.findPaidGuideByCoachId(coachId);
	}

	@Override
	public void updateCoachInfomation(Coach coach)
	{
		coachMapper.updateCoachInfomation(coach);
	}

	@Override
	public List<Guide> findGuideByCoachId(Integer coachId)
	{
		return guideMapper.findGuideByCoachId(coachId);
	}

	@Override
	public Guide findGuideByGuideId(Integer guideId)
	{
		return guideMapper.findGuideByGuideId(guideId);
	}

	@Override
	public void updateGuide(Guide guide)
	{
		guideMapper.updateGuide(guide);
	}
}
