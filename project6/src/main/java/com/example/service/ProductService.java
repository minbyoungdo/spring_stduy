package com.example.service;

import java.util.List;
import com.example.domain.Product_CategoryVO;
import org.apache.ibatis.annotations.Param;
public interface ProductService {
	public Product_CategoryVO get(String category);
	public List<Product_CategoryVO> getlist();
	public int getcount();
}
