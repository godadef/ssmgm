package com.yq.cn.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.cn.dao.CategoryMapper;
import com.yq.cn.dao.entity.Category;
import com.yq.cn.service.ICatogeryService;

@Service("catogeryService")
public class CatogeryServiceImpl implements ICatogeryService {

	@Autowired
	CategoryMapper categoryMapper;

	public Set<Category> getpsById() {
		return categoryMapper.getpsById();
	}

}
