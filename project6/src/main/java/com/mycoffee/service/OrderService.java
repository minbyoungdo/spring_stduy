package com.mycoffee.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycoffee.domain.OrderVO;
import com.mycoffee.domain.Order_detailVO;
public interface OrderService {
	public void insertOrder(String oid, String userid, int totalprice,int status);
	public int deleteorder(OrderVO order);
	public int updateorder(OrderVO order);
	public int countlist(String userid);
	public int countstatus(String userid, int status);
	public OrderVO selectstatus0(String userid);
	public OrderVO get();
	public List<OrderVO> getlist();
	
	//orderdetail
	public void insertOrder_detail(String oid,String pid, int price);
	public List<Order_detailVO> getodlist(String oid, String pid);
	public Order_detailVO selectstatus_detail(String oid);
	public Order_detailVO selectstatus_detail2(String oid, String pid);
}