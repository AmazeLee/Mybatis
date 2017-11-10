package com.sh.mybatis.mapper;

import java.util.List;

import com.sh.mybatis.pojo.Orders;
import com.sh.mybatis.pojo.User;

public interface OrderMapper {
	
	//查询订单表oreder的所有数据
	public List<Orders> selectOrdersList();
	
	//一对一关联查询 以订单为中心关联用户
	public List<Orders> selectOrders();
	
	//一对多关联
	public List<User> selectUserList();
}
