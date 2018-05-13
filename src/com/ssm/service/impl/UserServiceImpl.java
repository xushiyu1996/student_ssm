package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mchange.v2.c3p0.cfg.C3P0ConfigFinder;
import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;
import com.ssm.po.User;
import com.ssm.service.UserService;
import com.ssm.mapper.CoachMapper;
import com.ssm.mapper.GuideMapper;
import com.ssm.mapper.PaidGuideMapper;
import com.ssm.mapper.UserMapper;

public class UserServiceImpl implements UserService
{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CoachMapper coachMapper;
	@Autowired
	private GuideMapper guideMapper;
	@Autowired
	private PaidGuideMapper paidguidemapper;

	@Override
	public void userRegist(User user)
	{
		userMapper.addUser(user);
	}

	@Override
	public boolean hasUser(String userUsername)
	{
		int i = userMapper.hasUser(userUsername);
		if (i == 1)
			return true;
		else
			return false;
	}

	@Override
	public User selectUserByUserNameAndPassword(User user)
	{
		return userMapper.selectUserByUserNameAndPassword(user);
	}

	@Override
	public List<Guide> getCheckedGuides()
	{
		return guideMapper.findCheckedGuide();
	}

	@Override
	public Guide getGuideById(Integer guideId)
	{
		return guideMapper.findGuideByGuideId(guideId);
	}

	@Override
	public void buyGuide(PaidGuide paidguide)
	{
		paidguidemapper.addPaidGuide(paidguide);
	}

	@Override
	public void updateUserMoney(User user)
	{
		userMapper.updateUserMoney(user);
	}

	@Override
	public List<PaidGuide> findPaidGuideByUserId(Integer userId)
	{
		return paidguidemapper.findPaidGuideByUserId(userId);
	}

	@Override
	public List<Guide> selectGuideByKey(String key)
	{
		return guideMapper.selectGuideByKey(key);
	}

	@Override
	public void ratePaidGuide(PaidGuide paidguide)
	{
		paidguidemapper.setPaidGuideRate(paidguide);
		List<PaidGuide> paidguidelist = paidguidemapper.getRatedPaiGuide(paidguide);
		int num = 0;
		int ratetotal = 0;
		for (PaidGuide paidguide1 : paidguidelist)
		{
			num++;
			ratetotal = ratetotal + paidguide1.getGuideRate();
		}
		double guideRate = ratetotal / num;
		Guide guide = new Guide();
		guide.setGuideId(paidguide.getGuideId());
		guide.setGuideRate(guideRate);
		guideMapper.setGuideRate(guide);
	}

	@Override
	public void updateUserInfomation(User user)
	{
		userMapper.updateUserInfomation(user);
	}

	@Override
	public Integer hasPaidGuide(PaidGuide paidguide)
	{
		return paidguidemapper.hasPaidGuide(paidguide);
	}

	@Override
	public void setGuideNumber(Guide guide)
	{
		guideMapper.setGuideNumber(guide);
	}

	@Override
	public List<Coach> getCoachOrderByNumber()
	{
		return coachMapper.getCoachOrderByNumber();
	}

	@Override
	public List<Coach> getCoachOrderByNumber2()
	{
		return coachMapper.getCoachOrderByNumber2();
	}

	@Override
	public List<Guide> selectGuideByType(String type)
	{
		return guideMapper.selectGuideByType(type);
	}

	@Override
	public List<Guide> findGuideByCoachId(Integer coachId)
	{
		return guideMapper.findGuideByCoachId(coachId);
	}

	@Override
	public List<PaidGuide> findPaidGuideByGuideId(Integer guideId)
	{
		return paidguidemapper.findPaidGuideByGuideId(guideId);
	}

	@Override
	public Coach getCoachByCoachId(Integer coachId)
	{
		return coachMapper.getCoachByCoachId(coachId);
	}

	@Override
	public PaidGuide findPaidGuideByUserIdAndGuideId(PaidGuide paidguide)
	{
		return paidguidemapper.findPaidGuideByUserIdAndGuideId(paidguide);
	}
}
