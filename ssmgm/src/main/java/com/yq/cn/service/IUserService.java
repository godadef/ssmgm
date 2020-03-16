package com.yq.cn.service;

import java.util.Map;

import com.yq.cn.dao.entity.User;

public interface IUserService {
	public User getUserById(long id);

	public User login(String loginName, String pass);

	public int insert(User user);
	
	public User getMyProducts(long id);

	public void deleteMyOneProduct(Map map);

	public void saveProductToMine(Map map);

	public void deleteMyProducts(Long id);

}
