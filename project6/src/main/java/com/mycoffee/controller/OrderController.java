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
	ProductService pservice;
	@GetMapping("/InsertOrder")
	public String insertorder(@RequestParam("category")String category,@RequestParam("tem") int tem,@RequestParam("cap") int cap,Model model,HttpServletRequest request)
	{ 
		//1현재 오더 중에 주문 작성(0) 상태가 있다면 oid 생성 x
		//-리스트로 확인하고 주문작성 상태인 주문 가져오기
		//usrid로 검색해서 찾기
		//2주문내역 자체가 없는 경우 당연히 oid 없을테니 생성
		//suerid로 검색하고 count값 받아오기
		//3주문내역은 있지만 주문 작성(0)상태가 없는 경우 oid 생성
		//4주문내역도 없고 주문작성상태도 없는 경우?
		//userid로 검색하고 없으면
		ProductJoinVO p =pservice.get2(category, tem, cap);//프로덕트 검색
		HttpSession session = request.getSession(false);//세션 확인
		UserVO user = (UserVO)session.getAttribute("sessionId");//유저값 세션으로 가져오기
		//service.countlist(user.getUserid());
		//log.info("가1나2다3라마바사아파그랴파구모야다글뫄ㅣ"+category+tem+cap);//확인
		//System.out.println(p);//확인
		
		//2.주문내역 자체가 없는경우 oid 생성 필요
		if(service.countlist(user.getUserid()) ==0)
		{
			Date now = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String oid = formatter.format(now);
			//System.out.println(oid);//확인
			service.insertOrder(oid,user.getUserid(),p.getPrice(),0);
			service.insertOrder_detail(oid, p.getPid(), p.getPrice());
			return "redirect:/user/User_Drink_Menu";
		}
		//1.주문내역이 있고 현재 오더 중에 주문 작성(0) 상태가 있다면 oid 생성 x
		else if(service.countlist(user.getUserid()) !=0 &&service.countstatus(user.getUserid(), 0) !=0)
		{
			return "redirect:/user/User_Main_Home";
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
	//장바구니 들어갈때
	@GetMapping("/User_Shopping_Basket")
	public void SelectOrderStatus0(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession(false);//세션 확인
		UserVO user = (UserVO)session.getAttribute("sessionId");//유저값 세션으로 가져오기
		//System.out.println("가나다라가나다라다나가"+ user);
		//System.out.println("가나다라가나다라다나가"+ service.countstatus(user.getUserid(), 0));
		//해당 아이디의 목록 중
		if(service.countstatus(user.getUserid(), 0)!=0)
		{
			//System.out.println("가나다라가나다라다나가"+ service.selectstatus0());
			//System.out.println("가나다라가나다라다나가"+ service.selectstatus_detail(service.selectstatus0().getOid()));
			model.addAttribute("order",service.selectstatus0(user.getUserid()));
			model.addAttribute("od",service.selectstatus_detail(service.selectstatus0(user.getUserid()).getOid()));
			request.setAttribute("order2", service.selectstatus0(user.getUserid()));
			request.setAttribute("od2", service.selectstatus_detail(service.selectstatus0(user.getUserid()).getOid()));
			request.setAttribute("product", pservice.get3(service.selectstatus_detail(service.selectstatus0(user.getUserid()).getOid()).getPid()));
		}
	}
	@GetMapping("/piecesChange")
	public void piecesChage(@RequestParam("str")String str,@RequestParam("category")String category,@RequestParam("tem")String tem,@RequestParam("cap")String cap,@RequestParam("pid")String pid, HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);//세션 확인
		UserVO user = (UserVO)session.getAttribute("sessionId");//유저아이디
		service.selectstatus0(user.getUserid()).getOid();//oid
		service.selectstatus_detail2(service.selectstatus0(user.getUserid()).getOid(), pid);
		if(str=="plus")
		{
		}
		else
		{
			if(service.selectstatus_detail2(service.selectstatus0(user.getUserid()).getOid(), pid).getPieces()== 0)
			{
				//delete 할수 있도록
			}
			else
			{
				//정상적으로
			}
		}
	}
}
