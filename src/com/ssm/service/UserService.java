package com.ssm.service;

import java.util.List;

import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;
import com.ssm.po.User;

public interface UserService
{
	public void userRegist(User user);

	public boolean hasUser(String userUsername);

	public User selectUserByUserNameAndPassword(User user);

	public List<Guide> getCheckedGuides();

	public Guide getGuideById(Integer guideId);

	public void buyGuide(PaidGuide paidguide);

	public void updateUserMoney(User user);

	public List<PaidGuide> findPaidGuideByUserId(Integer userId);

	public List<Guide> selectGuideByKey(String key);

	public void ratePaidGuide(PaidGuide paidguide);

	public void updateUserInfomation(User user);

	public Integer hasPaidGuide(PaidGuide paidguide);

	public void setGuideNumber(Guide guide);

	public List<Coach> getCoachOrderByNumber();

	public List<Coach> getCoachOrderByNumber2();

	public List<Guide> selectGuideByType(String type);

	public List<Guide> findGuideByCoachId(Integer coachId);

	public List<PaidGuide> findPaidGuideByGuideId(Integer guideId);

	public Coach getCoachByCoachId(Integer coachId);

	public PaidGuide findPaidGuideByUserIdAndGuideId(PaidGuide paidguide);

}
