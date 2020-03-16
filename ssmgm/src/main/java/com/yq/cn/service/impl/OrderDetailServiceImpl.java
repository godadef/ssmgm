package com.yq.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.cn.dao.OrderDetailMapper;
import com.yq.cn.dao.entity.OrderDetail;
import com.yq.cn.service.IOrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements IOrderDetailService {
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	public void insert(List<OrderDetail> list) {
		orderDetailMapper.insertOrderDetails(list);
		
	}

}
