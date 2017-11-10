package com.sh.mybatis.mapper;

import java.util.List;

import com.sh.mybatis.pojo.Orders;

public interface OrderMapper {
	
	//查询订单表oreder的所有数据
	public List<Orders> selectOrdersList();
}
