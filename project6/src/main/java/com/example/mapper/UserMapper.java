package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.UserVO;

public interface UserMapper {
	//@Select("select * from tbl_user")
	public List<UserVO> getList();
}
