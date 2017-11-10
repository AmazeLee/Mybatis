package com.sh.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sh.mybatis.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User queryUserById(int id) {
		// ��ȡSqlSession
		SqlSession sqlSession = super.getSqlSession();

		// ʹ��SqlSessionִ�в���
		User user = sqlSession.selectOne("queryUserById", id);

		// ��Ҫ�ر�sqlSession

		return user;
	}
}
