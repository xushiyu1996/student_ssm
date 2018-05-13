package com.ssm.po;

import javax.validation.constraints.Size;

public class User
{

	private Integer userId;
	@Size(min = 1, max = 20, message = "名字长度应该在1-20以内")
	private String userName;
	@Size(min = 1, max = 20, message = "手机号长度应该在1-20以内")
	private String userMobile;
	private String userGender;
	@Size(min = 1, max = 20, message = "用户名长度应该在1-20以内")
	private String userUsername;
	@Size(min = 1, max = 20, message = "密码长度应该在1-20以内")
	private String userPassword;
	@Size(min = 1, max = 20, message = "大学长度应该在1-20以内")
	private String userUniversity;
	private String userGrade;
	@Size(min = 0, max = 20, message = "专业长度应该在1-20以内")
	private String userMajor;
	@Size(min = 0, max = 2000, message = "自我介绍长度应该在1-2000以内")
	private String userIntroduction;

	private Integer userNumber;

	private Integer userMoney;

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserMobile()
	{
		return userMobile;
	}

	public void setUserMobile(String userMobile)
	{
		this.userMobile = userMobile;
	}

	public String getUserGender()
	{
		return userGender;
	}

	public void setUserGender(String userGender)
	{
		this.userGender = userGender;
	}

	public String getUserUsername()
	{
		return userUsername;
	}

	public void setUserUsername(String userUsername)
	{
		this.userUsername = userUsername;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getUserUniversity()
	{
		return userUniversity;
	}

	public void setUserUniversity(String userUniversity)
	{
		this.userUniversity = userUniversity;
	}

	public String getUserGrade()
	{
		return userGrade;
	}

	public void setUserGrade(String userGrade)
	{
		this.userGrade = userGrade;
	}

	public String getUserMajor()
	{
		return userMajor;
	}

	public void setUserMajor(String userMajor)
	{
		this.userMajor = userMajor;
	}

	public String getUserIntroduction()
	{
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction)
	{
		this.userIntroduction = userIntroduction;
	}

	public Integer getUserNumber()
	{
		return userNumber;
	}

	public void setUserNumber(Integer userNumber)
	{
		this.userNumber = userNumber;
	}

	public Integer getUserMoney()
	{
		return userMoney;
	}

	public void setUserMoney(Integer userMoney)
	{
		this.userMoney = userMoney;
	}

}
