package com.sh.mybatis.junit;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sh.mybatis.mapper.UserMapper;
import com.sh.mybatis.pojo.User;

public class UserMapperTest {

	@Test
	public void testMapper() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
		//UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
}
