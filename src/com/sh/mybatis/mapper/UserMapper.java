package com.sh.mybatis.mapper;


import java.util.List;

import com.sh.mybatis.pojo.QueryVo;
import com.sh.mybatis.pojo.User;

public interface UserMapper {
	
	//遵循四个原则
	//接口 方法名 == User.xml 中id名
	//返回值类型与Mapper.xml文件中返回值类型要一致
	//方法的入参类型与Mapper.xml中入参类型要一致
	//命名空间绑定此接口
	public User findUserById(Integer id);
	
	//通过包装类查询用户
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//查询数据条数
	public Integer countUser();
	
	//根据性别和名字查询用户
	public List<User> selectUserBySexAndUsername(User user);
	
	//根据多个id查询用户信息
	//public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIds(List<Integer> ids);
	//public List<User> selectUserByIds(QueryVo vo);
}
