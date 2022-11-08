package com.mycoffee.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mycoffee.domain.OrderVO;
import com.mycoffee.domain.Order_detailVO;
import com.mycoffee.mapper.OrderMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
	private OrderMapper mapper;
	
	@Override
	public void insertOrder(String oid, String userid, int totalprice,int status) {
		mapper.insertOrder(oid, userid, totalprice,status);
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
	@Override
	public int countlist(String userid) {
		return mapper.countlist(userid);
	}
	@Override
	public int countstatus(String userid, int status) {
		return mapper.countstatus(userid, status);
	}
	@Override
	public OrderVO selectstatus0(String userid) {
		return mapper.selectstatus0(userid);
	}
	
	//detail
	
	@Override
	public List<Order_detailVO> getodlist(String oid, String pid) {
		return (List<Order_detailVO>) mapper.getodlist(oid, pid);
	}
	@Override
	public void insertOrder_detail(String oid, String pid, int price) {
		mapper.insertOrderdetail(oid, pid, price);
	}
	@Override
	public Order_detailVO selectstatus_detail(String oid) {
		
		return mapper.select_detail(oid);
	}
	@Override
	public Order_detailVO selectstatus_detail2(String oid, String pid) {
		return mapper.select_detail2(oid, pid);
	}

}