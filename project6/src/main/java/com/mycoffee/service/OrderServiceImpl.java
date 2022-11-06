package com.mycoffee.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mycoffee.domain.OrderVO;
import com.mycoffee.mapper.OrderMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
	private OrderMapper mapper;
	
	@Override
	public void insertOrder(OrderVO order) {
		mapper.insertOrder(null, null, null);
	}

	@Override
	public int deleteorder(OrderVO order) {
		mapper.delete(null, null, null);
		return 0;
	}

	@Override
	public int updateorder(OrderVO order) {
		mapper.update();
		return 0;
	}

	@Override
	public OrderVO get() {
		mapper.get(null);
		return null;
	}

	@Override
	public List<OrderVO> getlist() {
		mapper.getlist(null);
		return null;
	}

}
