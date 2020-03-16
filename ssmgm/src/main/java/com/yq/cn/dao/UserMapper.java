package com.yq.cn.dao;

import java.util.Map;
import java.util.Set;

import com.yq.cn.dao.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User login(Map map);
	
	public User getMyProducts(long id);

	void deleteMyOneProduct(Map map);

	void saveProductToMine(Map map);

	void deleteMyProducts(long id);
	
}