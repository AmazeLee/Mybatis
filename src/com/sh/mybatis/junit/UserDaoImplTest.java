package com.sh.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sh.mybatis.dao.UserDao;
import com.sh.mybatis.dao.UserDaoImpl;
import com.sh.mybatis.pojo.User;

public class UserDaoImplTest {

	public SqlSessionFactory sqlSessionFactory;

	@Before
	public void Before() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testDao() {

		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}

}
