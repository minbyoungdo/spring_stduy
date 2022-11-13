package com.mycoffee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mycoffee.domain.CodesVO;
import com.mycoffee.domain.ProductJoinVO;
import com.mycoffee.domain.Product_CategoryVO;

public interface ProductMapper {
	public Product_CategoryVO get(String category);
	public ProductJoinVO get2(@Param("category")String category,@Param("tem")int tem, @Param("cap")int cap);
	public ProductJoinVO get3(String pid);
	public List<CodesVO> getCodeList(String type);
	//public List<Product_CategoryVO> getlist();
	//public List<Product_CategoryVO> getlist1(String category);
	public List<ProductJoinVO> getlist1(String category);
	public int getcount();
	public List<Product_CategoryVO> getlist(int tpype);
}
