package com.ssm.mapper;

import java.util.List;

import com.ssm.po.Coach;
import com.ssm.po.User;

public interface CoachMapper
{

	public void addCoach(Coach coach);

	public Integer hasCoach(String coachUsername);

	public Coach selectCoachByUserNameAndPassword(Coach coach);

	public Coach getCoachByCoachId(Integer coachId);

	public void updateCoachMoney(Coach coach);

	public void updateCoachInfomation(Coach coach);

	public List<Coach> getCoachOrderByNumber();

	public List<Coach> getCoachOrderByNumber2();

}
