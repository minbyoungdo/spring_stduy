package com.mycoffee.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycoffee.domain.OrderVO;
public interface OrderService {
	public void insertOrder(OrderVO order);
	public int deleteorder(OrderVO order);
	public int updateorder(OrderVO order);
	public int countlist(String userid);
	public int countstatus(String userid, int status);
	public OrderVO get();
	public List<OrderVO> getlist();
	
}
