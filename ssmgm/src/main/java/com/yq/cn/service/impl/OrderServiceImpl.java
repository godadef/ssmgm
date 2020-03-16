package com.yq.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.cn.dao.OrderMapper;
import com.yq.cn.dao.entity.Order;
import com.yq.cn.service.IOrderService;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;

	public void insert(Order order) {
		orderMapper.insert(order);
	}

}
