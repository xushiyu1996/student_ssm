package com.ssm.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaidGuide
{
	private Integer coachId;
	private Integer userId;
	private Integer guideId;
	private String coachName;
	private String userName;
	private String guideName;
	private Integer guidePrice;
	@Min(value = 0, message = "评分应该大于等于0")
	@Max(value = 10, message = "评分应该小于等于10")
	@NotNull(message = "评分不为空")
	private Integer guideRate;
	@Size(min = 1, max = 1500, message = "评价长度应该在1-1500以内")
	private String guideRemark;

	public Integer getCoachId()
	{
		return coachId;
	}

	public void setCoachId(Integer coachId)
	{
		this.coachId = coachId;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getGuideId()
	{
		return guideId;
	}

	public void setGuideId(Integer guideId)
	{
		this.guideId = guideId;
	}

	public String getCoachName()
	{
		return coachName;
	}

	public void setCoachName(String coachName)
	{
		this.coachName = coachName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getGuideName()
	{
		return guideName;
	}

	public void setGuideName(String guideName)
	{
		this.guideName = guideName;
	}

	public Integer getGuidePrice()
	{
		return guidePrice;
	}

	public void setGuidePrice(Integer guidePrice)
	{
		this.guidePrice = guidePrice;
	}

	public Integer getGuideRate()
	{
		return guideRate;
	}

	public void setGuideRate(Integer guideRate)
	{
		this.guideRate = guideRate;
	}

	public String getGuideRemark()
	{
		return guideRemark;
	}

	public void setGuideRemark(String guideRemark)
	{
		this.guideRemark = guideRemark;
	}

}