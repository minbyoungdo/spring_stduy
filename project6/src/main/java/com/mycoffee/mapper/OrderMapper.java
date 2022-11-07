package com.mycoffee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mycoffee.domain.OrderVO;

public interface OrderMapper {
	//insert
	public void insertOrder(@Param("pcategory")String category, @Param("temperature")String temperature, @Param("capacity")String capacity);
	//delete
	public int delete(@Param("pcategory")String category, @Param("temperature")String temperature, @Param("capacity")String capacity);
	//update
	public int update();
	//select
	public OrderVO get(String oid);
	//select list
	public List<OrderVO> getlist(String oid);
	public int countlist(String userid);
	public int countstatus(String userid, int status);
}
