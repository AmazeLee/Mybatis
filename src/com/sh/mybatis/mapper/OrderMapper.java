package com.sh.mybatis.mapper;

import java.util.List;

import com.sh.mybatis.pojo.Orders;

public interface OrderMapper {
	
	//��ѯ������oreder����������
	public List<Orders> selectOrdersList();
}
