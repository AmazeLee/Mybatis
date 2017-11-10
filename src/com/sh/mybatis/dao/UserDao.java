package com.sh.mybatis.dao;

import com.sh.mybatis.pojo.User;

public interface UserDao {
	User queryUserById(int id);
}
