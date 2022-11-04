package com.mycoffee.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.mycoffee.domain.ProductJoinVO;
import com.mycoffee.domain.Product_CategoryVO;
import com.mycoffee.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private ProductMapper mapper;
	
	@Override
	public Product_CategoryVO get(String category) {
		log.info(category);
		log.info(mapper.get(category));
		return mapper.get(category);
		
	}

	@Override
	public List<Product_CategoryVO> getlist() {
		log.info("get........");
		return mapper.getlist();
	}

	@Override
	public int getcount() {
		log.info("get........");
		int i =mapper.getcount();
		return i;
	}

	/*
	 * @Override public List<Product_CategoryVO> getlist1(String category) { return
	 * mapper.getlist1(category); }
	 */
	@Override
	public List<ProductJoinVO> getlist1(String category) {
		//log.info(mapper.getlist1(category));
		return mapper.getlist1(category);
	}

}
