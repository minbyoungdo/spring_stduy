package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.ProductVO;

public interface ProductMapper {
	public ProductVO get();
	public List<ProductVO> getlist();
	public int getcount();
}
