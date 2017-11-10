package com.sh.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sh.mybatis.mapper.UserMapper;
import com.sh.mybatis.pojo.User;

public class UserMapperTest {

	@Test
	public void testUserMapper() throws Exception {
		// 1.���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.����һ�� SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//sqlSession��æ����һ��ʵ���ࣨ���ӿڣ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}

}
