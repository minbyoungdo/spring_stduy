package com.example.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private ProductMapper mapper;
	
	@Override
	public ProductVO get() {
		log.info("get........");
		mapper.get();
		return null;
	}

	@Override
	public List<ProductVO> getlist() {
		log.info("get........");
		mapper.getlist();
		return null;
	}

	@Override
	public int getcount() {
		log.info("get........");
		int i =mapper.getcount();
		return i;
	}

}
