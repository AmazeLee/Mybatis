package com.sh.mybatis.mapper;


import java.util.List;

import com.sh.mybatis.pojo.QueryVo;
import com.sh.mybatis.pojo.User;

public interface UserMapper {
	
	//��ѭ�ĸ�ԭ��
	//�ӿ� ������ == User.xml ��id��
	//����ֵ������Mapper.xml�ļ��з���ֵ����Ҫһ��
	//���������������Mapper.xml���������Ҫһ��
	//�����ռ�󶨴˽ӿ�
	public User findUserById(Integer id);
	
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//��ѯ��������
	public Integer countUser();
	
	//�����Ա�����ֲ�ѯ�û�
	public List<User> selectUserBySexAndUsername(User user);
	
	//���ݶ��id��ѯ�û���Ϣ
	//public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIds(List<Integer> ids);
	//public List<User> selectUserByIds(QueryVo vo);
}
