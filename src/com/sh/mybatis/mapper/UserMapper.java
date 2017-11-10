package com.sh.mybatis.mapper;

import com.sh.mybatis.pojo.User;

public interface UserMapper {
	
	public User findUserById(Integer id);
}
