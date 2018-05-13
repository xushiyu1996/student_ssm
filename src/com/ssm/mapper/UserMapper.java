package com.ssm.mapper;

import com.ssm.po.User;

public interface UserMapper
{
	public void addUser(User user);

	public Integer hasUser(String userUserName);

	public User selectUserByUserNameAndPassword(User user);

	public void updateUserMoney(User user);

	public void updateUserInfomation(User user);

}
