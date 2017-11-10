package com.sh.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sh.mybatis.mapper.OrderMapper;
import com.sh.mybatis.pojo.Orders;
import com.sh.mybatis.pojo.User;

public class OrderMapperTest {

	@Test
	public void testOrderList() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// sqlSession帮忙生成一个实现类（给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> ordersList = orderMapper.selectOrdersList();
		
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void testOrders() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// sqlSession帮忙生成一个实现类（给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> ordersList = orderMapper.selectOrders();
		
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}
	
	@Test
	public void testUserList() throws Exception {
		// 1.加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.创建一个 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// sqlSession帮忙生成一个实现类（给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<User> userList = orderMapper.selectUserList();
		for (User user : userList) {
			System.out.println(user);
		}
		
	}
}
