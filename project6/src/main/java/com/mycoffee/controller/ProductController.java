package com.mycoffee.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycoffee.domain.Criteria;
import com.mycoffee.domain.Product_CategoryVO;
import com.mycoffee.domain.ProductJoinVO;
import com.mycoffee.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@WebAppConfiguration
@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class ProductController {
	private ProductService service;
	
	@GetMapping()
	public void Nomarl()
	{
		
	}


	//전체 리스트 가져올 때 사용-메뉴 페이지
	@GetMapping("/User_Drink_Menu")
	public void getlist(Model model)
	{
		model.addAttribute("list",service.getlist());
	}
	//해당 카테고리에 포함되는 리스트만 가져오기 -상세 설명 페이지/상세 주문 페이지
	@GetMapping({"/User_One_Drink","User_Drink_Order"})
	public void get(@RequestParam("category") String category,Model model,HttpServletRequest request)
	{
		//log.info(service.getlist1(category));
		model.addAttribute("product",service.get(category));
		model.addAttribute("list",service.getlist1(category));
		request.setAttribute("list", service.getlist1(category));
	}
	//카테고리,온도,용량의 파라미터를 통해 pid,객체 자체get을 해서 가져오고
	//리다이렉트로 ordercontroller로 이동해서 작동
	/*
	 * @PostMapping("/User_Order") public String get2(ProductJoinVO
	 * product,RedirectAttributes rttr) { log.info(product);
	 * log.info(service.get2(product.getPcategory(),product.getTemperature(),product
	 * .getCapacity()));
	 * service.get2(product.getPcategory(),product.getTemperature(),product.
	 * getCapacity()); return "redirect:/user/User_Main_Home"; },@RequestParam("tem") int tem,@RequestParam("cap") int cap,
	 */
	@GetMapping("/User_Order")
	public String get2(@RequestParam("category") String category,@RequestParam("tem") int tem,@RequestParam("cap") int cap,RedirectAttributes rttr,Model model,HttpServletRequest request)
	{
		//log.info(category);
		//log.info(tem);
		//log.info(cap);
		//log.info(service.get2(category,tem,cap));
		model.addAttribute("product",service.get2(category,tem,cap));
		request.setAttribute("product1", service.get2(category,tem,cap));
		//service.get2(category,tem,cap);
		return "redirect:/user/CheckSession2?str=InsertOrder & category="+category+ "& tem="+tem +"& cap="+cap;
		
	}
}
