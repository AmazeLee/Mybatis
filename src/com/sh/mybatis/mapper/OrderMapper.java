package com.sh.mybatis.mapper;

import java.util.List;

import com.sh.mybatis.pojo.Orders;
import com.sh.mybatis.pojo.User;

public interface OrderMapper {
	
	//��ѯ������oreder����������
	public List<Orders> selectOrdersList();
	
	//һ��һ������ѯ �Զ���Ϊ���Ĺ����û�
	public List<Orders> selectOrders();
	
	//һ�Զ����
	public List<User> selectUserList();
}
