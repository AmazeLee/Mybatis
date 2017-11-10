package com.sh.mybatis.dao;

import com.sh.mybatis.pojo.User;

public interface UserDao {
	public User selectUserById(Integer id);
}
