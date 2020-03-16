package com.yq.cn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.cn.dao.ProductMapper;
import com.yq.cn.dao.entity.Product;
import com.yq.cn.service.IProductService;
import com.yq.cn.utils.Page;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper productMapper;
	public Set<Product> getIndexProduct() {
		return productMapper.getIndexProduct();
	}
	public Product getProduct(long id) {
		return productMapper.getProduct(id);
	}
	public List<Product> listSameProduct(int id) {
		return productMapper.listSameProduct(id);
	}
	public List<Product> getProductPageInfo(int id,int currentPage, int pageSize) {
		currentPage = (currentPage-1)*pageSize;
		Map map = new HashMap();
		map.put("id", id);
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		
		return productMapper.getProductPageInfo(map);
	}
	public int countClassProduct(int id) {
		// TODO Auto-generated method stub
		return productMapper.countClassProduct(id);
	}

}
