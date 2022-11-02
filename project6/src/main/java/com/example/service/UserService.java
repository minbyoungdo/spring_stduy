package com.example.service;

import com.example.domain.UserVO;
import org.apache.ibatis.annotations.Param;
public interface UserService 
{
	public void sele();
	public void register(UserVO user);
	public UserVO LoginUser(@Param("userid")String userid, @Param("password")String password);
	public boolean modify(UserVO user);
	public boolean remove(String id);
	public void insertUser(UserVO user);
}
