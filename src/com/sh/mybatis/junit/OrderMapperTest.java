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

public class OrderMapperTest {

	@Test
	public void testOrderList() throws Exception {
		// 1.���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.����һ�� SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// sqlSession��æ����һ��ʵ���ࣨ���ӿڣ�
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> ordersList = orderMapper.selectOrdersList();
		
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}
}
