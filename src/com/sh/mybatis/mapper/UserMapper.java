package com.sh.mybatis.mapper;

import com.sh.mybatis.pojo.User;

public interface UserMapper {
	
	//��ѭ�ĸ�ԭ��
	//�ӿ� ������ == User.xml ��id��
	//����ֵ������Mapper.xml�ļ��з���ֵ����Ҫһ��
	//���������������Mapper.xml���������Ҫһ��
	//�����ռ�󶨴˽ӿ�
	public User findUserById(Integer id);
}
