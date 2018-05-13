package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.AdministratorMapper;
import com.ssm.mapper.GuideMapper;
import com.ssm.po.Administrator;
import com.ssm.po.Guide;
import com.ssm.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService
{
	@Autowired
	private AdministratorMapper administratorMapper;
	@Autowired
	private GuideMapper guideMapper;

	@Override
	public Administrator selectAdministratorByUserNameAndPassword(Administrator administrator)
	{
		return administratorMapper.selectAdministratorByUserNameAndPassword(administrator);
	}

	@Override
	public List<Guide> findUncheckedGuide()
	{
		return guideMapper.findUncheckedGuide();
	}

	@Override
	public void checkGuide(Integer guideId)
	{
		guideMapper.checkGuide(guideId);
	}

}
