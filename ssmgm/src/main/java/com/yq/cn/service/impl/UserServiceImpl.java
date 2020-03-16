package com.yq.cn.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.cn.dao.UserMapper;
import com.yq.cn.dao.entity.User;
import com.yq.cn.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public User login(String loginName, String pass) {
		Map map = new HashMap();
		map.put("loginName", loginName);
		map.put("pass", pass);
		return userMapper.login(map);
	}

	public int insert(User user) {
		return userMapper.insert(user);
	}

	public User getMyProducts(long id) {
		return userMapper.getMyProducts(id);
	}

	public void deleteMyOneProduct(Map map) {
		userMapper.deleteMyOneProduct(map);
		
	}

	public void saveProductToMine(Map map) {
		try {
			userMapper.saveProductToMine(map);
		} catch (Exception e) {
			
		}
		
	}

	public void deleteMyProducts(Long id) {
		userMapper.deleteMyProducts(id);
		
	}
	

}
