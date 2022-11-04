package com.mycoffee.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycoffee.domain.ProductJoinVO;
import com.mycoffee.domain.Product_CategoryVO;
public interface ProductService {
	public Product_CategoryVO get(String category);
	public List<Product_CategoryVO> getlist();
	//public List<Product_CategoryVO> getlist1(String category);
	public List<ProductJoinVO> getlist1(String category);
	public int getcount();
}
