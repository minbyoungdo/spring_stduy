package com.mycoffee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.mycoffee.domain.UserVO;
import com.mycoffee.domain.OrderVO;
import com.mycoffee.domain.OrderJoinVO;
import com.mycoffee.service.OrderService;
import com.mycoffee.domain.ProductJoinVO;
import com.mycoffee.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@WebAppConfiguration
@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class OrderController 
{
	OrderService service;
	@GetMapping("/InsertOrder")
	public String insertorder(@RequestParam("category")String category,@RequestParam("tem") int tem,@RequestParam("cap") int cap,Model model,HttpServletRequest request)
	{ //CheckSession?str=
		//oid 생성 방법1
		// 현재 날짜/시간
       // Date now = new Date();
        // 현재 날짜/시간 출력
       // System.out.println(now); // Thu Jun 17 06:57:32 KST 2021
        // 포맷팅 정의
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        // 포맷팅 적용
       // String formatedNow = formatter.format(now);
        // 포맷팅 현재 날짜/시간 출력
        //System.out.println(formatedNow);

	
		//1현재 오더 중에 주문 작성(0) 상태가 있다면 oid 생성 x
		//-리스트로 확인하고 주문작성 상태인 주문 가져오기
		//usrid로 검색해서 찾기
		//2주문내역 자체가 없는 경우 당연히 oid 없을테니 생성
		//suerid로 검색하고 count값 받아오기
		//3주문내역은 있지만 주문 작성(0)상태가 없는 경우 oid 생성
		//4주문내역도 없고 주문작성상태도 없는 경우?
		//userid로 검색하고 없으면
		
		HttpSession session = request.getSession(false);
		UserVO user = (UserVO)session.getAttribute("sessionId");
		service.countlist(user.getUserid());
		 ProductJoinVO product= (ProductJoinVO)model.getAttribute("product");
		 ProductJoinVO product1= (ProductJoinVO)request.getAttribute("product1");
		// log.info("가나다라마바사아파그랴파구모야다글뫄ㅣ"+tem+category+cap);
		// log.info("가나다라마바사아파그랴파구모야다글뫄ㅣ"+product1);
		//2.주문내역 자체가 없는경우 oid 생성 필요
		if(service.countlist(user.getUserid()) ==0)
		{
			Date now = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String oid = formatter.format(now);
			System.out.println(oid);
			//service.insertOrder(oid,user.getUserid(),,0,);
			return "redirect:/user/User_Drink_Menu";
		}
		//1.주문내역이 있고 현재 오더 중에 주문 작성(0) 상태가 있다면 oid 생성 x
		else if(service.countlist(user.getUserid()) !=0 &&service.countstatus(user.getUserid(), 0) !=0)
		{
			return "redirect:/user/User_Drink_Menu";
		}
		//3.주문내역이 있고 오더 중 주문 작성 상태가 없어서 oid 생성 필요
		else if(service.countlist(user.getUserid()) !=0 &&service.countstatus(user.getUserid(), 0) ==0)
		{
			Date now = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String oid = formatter.format(now);
			System.out.println(oid);
			return "redirect:/user/User_Drink_Menu";
		}
		
		return "redirect:/user/User_Drink_Menu";
		
		
	}
}
