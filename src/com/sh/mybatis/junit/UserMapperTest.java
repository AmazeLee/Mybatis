package com.sh.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sh.mybatis.mapper.UserMapper;
import com.sh.mybatis.pojo.QueryVo;
import com.sh.mybatis.pojo.User;

public class UserMapperTest {

	@Test
	public void testUserMapper() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//sqlSession帮忙生成一个实现类（给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}

	@Test
	public void testUserMapperQueryVo() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//sqlSession帮忙生成一个实现类（给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		
		List<User> users = userMapper.findUserByQueryVo(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testUserMapperQueryVoCount() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//sqlSession帮忙生成一个实现类（给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Integer i = userMapper.countUser();
		System.out.println(i);
	}

}
