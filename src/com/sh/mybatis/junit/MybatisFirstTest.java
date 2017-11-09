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

	// �����û�id��ѯ
	@Test
	public void testMybatis() throws Exception {
		// 1.���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.����һ�� SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 4.ִ��sql���
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}

	// �����û���ģ����ѯ
	@Test
	public void testfindUserByUsername() throws Exception {
		// 1.���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		// 2.����һ�� SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 3.����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 4.ִ��sql���
		List<User> list = sqlSession.selectList("test.findUserByUsername", "��");
		for (User user : list) {
			System.out.println(user);
		}
	}

	// ����û�
	@Test
	public void testInsertUser() throws Exception {
		// ���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ִ��Sql���
		User user = new User();
		user.setUsername("��־Ħ");
		user.setBirthday(new Date());
		user.setAddress("�Ϻ�̲");
		user.setSex("��");
		int i = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();

		System.out.println(user.getId());
	}

	// �޸��û�
	@Test
	public void testUpdateUserById() throws Exception {
		// ���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ִ��Sql���
		User user = new User();
		user.setId(29);
		user.setUsername("������");
		user.setBirthday(new Date());
		user.setAddress("�Ϻ�̲");
		user.setSex("��");
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
	}

	// ɾ���û�
	@Test
	public void testDeleteUserById() throws Exception {
		// ���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ִ��Sql���
		sqlSession.delete("test.deleteUserById",30);
		sqlSession.commit();
	}
}
