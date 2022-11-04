package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Product_CategoryVO;

public interface ProductMapper {
	public Product_CategoryVO get(String category);
	public List<Product_CategoryVO> getlist();
	public int getcount();
}
