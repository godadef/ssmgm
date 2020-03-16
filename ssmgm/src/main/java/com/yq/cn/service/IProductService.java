package com.yq.cn.service;

import java.util.List;
import java.util.Set;

import com.yq.cn.dao.entity.Product;
import com.yq.cn.utils.Page;

public interface IProductService {
	public Set<Product> getIndexProduct();
	
	public Product getProduct(long id);
	
	public List<Product> listSameProduct(int id);

	public List<Product> getProductPageInfo(int id,int currentPage, int pageSize);

	public int countClassProduct(int id);

}
