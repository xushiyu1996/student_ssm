package com.ssm.mapper;

import com.ssm.po.Administrator;

public interface AdministratorMapper
{
	public Administrator selectAdministratorByUserNameAndPassword(Administrator administrator);

}
