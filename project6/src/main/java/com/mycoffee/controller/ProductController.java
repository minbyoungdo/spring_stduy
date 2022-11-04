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

	/*
	 * @GetMapping("/User_Drink_Menu") public void getlist(@RequestParam("category")
	 * String category, Model model) { log.info(category);
	 * model.addAttribute("list",service.getlist()); }
	 */
	@GetMapping("/User_Drink_Menu")
	public void getlist(Model model)
	{
		model.addAttribute("list",service.getlist());
	}
	@GetMapping("/User_One_Drink")
	public void get(@RequestParam("category") String category,Model model)
	{
		//log.info(service.getlist1(category));
		//category.addAttribute("product",service.get(category));
		model.addAttribute("list",service.getlist1(category));
		
	}
}
