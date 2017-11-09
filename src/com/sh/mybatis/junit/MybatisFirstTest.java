package com.sh.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sh.mybatis.pojo.User;

public class MybatisFirstTest {

	// 根据用户id查询
	@Test
	public void testMybatis() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 4.执行sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}

	// 根据用户名模糊查询
	@Test
	public void testfindUserByUsername() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 4.执行sql语句
		List<User> list = sqlSession.selectList("test.findUserByUsername", "五");
		for (User user : list) {
			System.out.println(user);
		}
	}

	// 添加用户
	@Test
	public void testInsertUser() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行Sql语句
		User user = new User();
		user.setUsername("徐志摩");
		user.setBirthday(new Date());
		user.setAddress("上海滩");
		user.setSex("男");
		int i = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();

		System.out.println(user.getId());
	}

	// 修改用户
	@Test
	public void testUpdateUserById() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行Sql语句
		User user = new User();
		user.setId(29);
		user.setUsername("戴望舒");
		user.setBirthday(new Date());
		user.setAddress("上海滩");
		user.setSex("男");
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
	}

	// 删除用户
	@Test
	public void testDeleteUserById() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行Sql语句
		sqlSession.delete("test.deleteUserById",30);
		sqlSession.commit();
	}
}
