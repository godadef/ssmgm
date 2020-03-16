package com.yq.cn.dao;

import java.util.List;

import com.yq.cn.dao.entity.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

	void insertOrderDetails(List<OrderDetail> list);
}