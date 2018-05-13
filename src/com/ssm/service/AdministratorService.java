package com.ssm.service;

import java.util.List;

import com.ssm.po.Administrator;
import com.ssm.po.Guide;

public interface AdministratorService
{
	public Administrator selectAdministratorByUserNameAndPassword(Administrator administrator);

	public List<Guide> findUncheckedGuide();

	public void checkGuide(Integer guideId);
}
