package com.ssm.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Guide
{
	private Integer guideId;

	private Integer coachId;

	private String coachName;

	private String guideType;
	@Min(value = 1, message = "指导时间应该大于0")
	@Max(value = 1000, message = "指导时间应该小于1000")
	@NotNull(message = "指导时间不为空")
	private Integer guideTimespan;
	@Size(min = 1, max = 20, message = "指导时间长度应该在1-20以内")
	private String guideTime;
	@Size(min = 1, max = 20, message = "指导地点长度应该在1-20以内")
	private String guidePlace;
	@Size(min = 1, max = 20, message = "指导名字长度应该在1-20以内")
	private String guideName;
	@Size(min = 1, max = 2000, message = "指导介绍长度应该在1-2000以内")
	private String guideIntroduction;
	@Min(value = 1, message = "指导价格应该大于0")
	@Max(value = 10000, message = "指导价格应该小于10000")
	@NotNull(message = "指导价格不为空")
	private Integer guidePrice;

	private Integer guideNumber;

	private Double guideRate;

	private Integer guideChecked;

	public Integer getGuideId()
	{
		return guideId;
	}

	public void setGuideId(Integer guideId)
	{
		this.guideId = guideId;
	}

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

	public String getGuideType()
	{
		return guideType;
	}

	public void setGuideType(String guideType)
	{
		this.guideType = guideType;
	}

	public Integer getGuideTimespan()
	{
		return guideTimespan;
	}

	public void setGuideTimespan(Integer guideTimespan)
	{
		this.guideTimespan = guideTimespan;
	}

	public String getGuideTime()
	{
		return guideTime;
	}

	public void setGuideTime(String guideTime)
	{
		this.guideTime = guideTime == null ? null : guideTime.trim();
	}

	public String getGuidePlace()
	{
		return guidePlace;
	}

	public void setGuidePlace(String guidePlace)
	{
		this.guidePlace = guidePlace == null ? null : guidePlace.trim();
	}

	public String getGuideName()
	{
		return guideName;
	}

	public void setGuideName(String guideName)
	{
		this.guideName = guideName == null ? null : guideName.trim();
	}

	public String getGuideIntroduction()
	{
		return guideIntroduction;
	}

	public void setGuideIntroduction(String guideIntroduction)
	{
		this.guideIntroduction = guideIntroduction == null ? null : guideIntroduction.trim();
	}

	public Integer getGuidePrice()
	{
		return guidePrice;
	}

	public void setGuidePrice(Integer guidePrice)
	{
		this.guidePrice = guidePrice;
	}

	public Integer getGuideNumber()
	{
		return guideNumber;
	}

	public void setGuideNumber(Integer guideNumber)
	{
		this.guideNumber = guideNumber;
	}

	public Double getGuideRate()
	{
		return guideRate;
	}

	public void setGuideRate(Double guideRate)
	{
		this.guideRate = guideRate;
	}

	public Integer getGuideChecked()
	{
		return guideChecked;
	}

	public void setGuideChecked(Integer guideChecked)
	{
		this.guideChecked = guideChecked;
	}
}