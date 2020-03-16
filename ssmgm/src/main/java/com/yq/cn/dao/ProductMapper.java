package com.yq.cn.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yq.cn.dao.entity.Image;
import com.yq.cn.dao.entity.Product;
import com.yq.cn.utils.Page;


public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    public Set<Product> getIndexProduct();
    
    public Product getProduct(long id);
    
    public List<Product> listOnePageInfo(int currentPage,int pageSize);
    
    public List<Product> listSameProduct(int id);

	List<Product> getProductPageInfo(Map map);

	int countClassProduct(int id);
    
    
}