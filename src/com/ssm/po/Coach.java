package com.ssm.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class Coach
{
	private Integer coachId;
	@Size(min = 1, max = 20, message = "名字长度应该在1-20以内")
	private String coachName;
	@Size(min = 1, max = 20, message = "手机号长度应该在1-20以内")
	private String coachMobile;
	private String coachGender;
	@Size(min = 1, max = 20, message = "用户名长度应该在1-20以内")
	private String coachUsername;
	@Size(min = 1, max = 20, message = "密码长度应该在1-20以内")
	private String coachPassword;
	@Size(min = 1, max = 20, message = "身份长度应该在1-20以内")
	private String coachIdentity;
	@Size(min = 1, max = 2000, message = "自我介绍长度应该在1-2000以内")
	private String coachIntroduction;
	@Min(value = 1, message = "回应时间应该大于0")
	@Max(value = 100, message = "回应时间应该小于100")
	@NotNull(message = "回应时间不为空")
	private Integer coachTime;

	private Integer coachNumber;

	private Integer coachMoney;

	private String coachPic;

	public Integer getCoachId()
	{
		return coachId;
	}

	public void setCoachId(Integer coachId)
	{
		this.coachId = coachId;
	}

	public String getCoachName()
	{
		return coachName;
	}

	public void setCoachName(String coachName)
	{
		this.coachName = coachName;
	}

	public String getCoachMobile()
	{
		return coachMobile;
	}

	public void setCoachMobile(String coachMobile)
	{
		this.coachMobile = coachMobile;
	}

	public String getCoachGender()
	{
		return coachGender;
	}

	public void setCoachGender(String coachGender)
	{
		this.coachGender = coachGender;
	}

	public String getCoachUsername()
	{
		return coachUsername;
	}

	public void setCoachUsername(String coachUsername)
	{
		this.coachUsername = coachUsername;
	}

	public String getCoachPassword()
	{
		return coachPassword;
	}

	public void setCoachPassword(String coachPassword)
	{
		this.coachPassword = coachPassword;
	}

	public String getCoachIdentity()
	{
		return coachIdentity;
	}

	public void setCoachIdentity(String coachIdentity)
	{
		this.coachIdentity = coachIdentity;
	}

	public String getCoachIntroduction()
	{
		return coachIntroduction;
	}

	public void setCoachIntroduction(String coachIntroduction)
	{
		this.coachIntroduction = coachIntroduction;
	}

	public Integer getCoachTime()
	{
		return coachTime;
	}

	public void setCoachTime(Integer coachTime)
	{
		this.coachTime = coachTime;
	}

	public Integer getCoachNumber()
	{
		return coachNumber;
	}

	public void setCoachNumber(Integer coachNumber)
	{
		this.coachNumber = coachNumber;
	}

	public Integer getCoachMoney()
	{
		return coachMoney;
	}

	public void setCoachMoney(Integer coachMoney)
	{
		this.coachMoney = coachMoney;
	}

	public String getCoachPic()
	{
		return coachPic;
	}

	public void setCoachPic(String coachPic)
	{
		this.coachPic = coachPic;
	}

}
