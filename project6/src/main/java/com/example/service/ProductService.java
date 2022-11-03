package com.example.service;

import java.util.List;
import com.example.domain.ProductVO;
import org.apache.ibatis.annotations.Param;
public interface ProductService {
	public ProductVO get();
	public List<ProductVO> getlist();
	public int getcount();
}
