package com.ssm.po;

public class Administrator
{
	private Integer administratorId;

	private String administratorName;

	private String administratorMobile;

	private String administratorGender;

	private String administratorUsername;

	private String administratorPassword;

	public Integer getAdministratorId()
	{
		return administratorId;
	}

	public void setAdministratorId(Integer administratorId)
	{
		this.administratorId = administratorId;
	}

	public String getAdministratorName()
	{
		return administratorName;
	}

	public void setAdministratorName(String administratorName)
	{
		this.administratorName = administratorName == null ? null : administratorName.trim();
	}

	public String getAdministratorMobile()
	{
		return administratorMobile;
	}

	public void setAdministratorMobile(String administratorMobile)
	{
		this.administratorMobile = administratorMobile == null ? null : administratorMobile.trim();
	}

	public String getAdministratorGender()
	{
		return administratorGender;
	}

	public void setAdministratorGender(String administratorGender)
	{
		this.administratorGender = administratorGender == null ? null : administratorGender.trim();
	}

	public String getAdministratorUsername()
	{
		return administratorUsername;
	}

	public void setAdministratorUsername(String administratorUsername)
	{
		this.administratorUsername = administratorUsername == null ? null : administratorUsername.trim();
	}

	public String getAdministratorPassword()
	{
		return administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword)
	{
		this.administratorPassword = administratorPassword == null ? null : administratorPassword.trim();
	}
}