package com.mycoffee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mycoffee.domain.OrderVO;
import com.mycoffee.domain.Order_detailVO;

public interface OrderMapper {
	//insert
	//사용
	public void insertOrder(@Param("oid")String oid, @Param("userid")String userid,@Param("totalprice") int totalprice, @Param("status")int status);
	//delete
	public int delete(@Param("pcategory")String category, @Param("temperature")String temperature, @Param("capacity")String capacity);
	//update
	public int update();
	//select
	public OrderVO get(String oid);
	//select list
	public List<OrderVO> getlist(String oid);
	//사용
	public int countlist(String userid);
	//사용?
	public int countstatus(@Param("userid")String userid, @Param("status")int status);
	public OrderVO selectstatus0(String userid);
	//detail
	//insert
	//사용
	public void insertOrderdetail(@Param("oid")String oid, @Param("pid")String pid,@Param("price") int price);
	//select
	public Order_detailVO getodlist(@Param("oid")String oid,@Param("pid")String pid);
	public Order_detailVO select_detail(String oid);
	public List<Order_detailVO> select_detailList(String oid);
	public Order_detailVO select_detail2(@Param("oid")String oid,@Param("pid")String pid);
	public int getpieces(@Param("oid")String oid,@Param("pid")String pid);
	public void piecesupdate(@Param("oid")String oid, @Param("pid")String pid, @Param("num")int num);
}
