package com.example.controller;

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

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.UserVO;
import com.example.service.BoardService;
import com.example.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@WebAppConfiguration
@Controller
@Log4j
@RequestMapping("/user/*")
@AllArgsConstructor
public class UserController {
	private UserService service;
	
	 @GetMapping({"/User_Login","User_Main_Home","User_Drink_Menu","User_SignUp"}) 
	  public void Nomarl() 
	 {}
	
	@PostMapping("/login")
	public String login(@RequestParam("userid") String id,@RequestParam("password") String passwd, Model model,HttpServletRequest request)
	{
		log.info("login"+id+passwd);
		HttpSession session = request.getSession();
		log.info(service.LoginUser(id,passwd));
		UserVO user1= new UserVO();
		user1 =service.LoginUser(id,passwd);
		log.info(user1);
		if(user1==null)
		{
			session.setAttribute("sessionId", null);
			return "redirect:/user/User_Login?msg=1";
		}
		else
		{
			UserVO user= new UserVO();
			user = service.LoginUser(id,passwd);
			session.setAttribute("sessionId", user);
			log.info("signup.."+user.getUserid());
			return "redirect:/user/User_Main_Home";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		log.info("logout..");
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:/user/User_Main_Home";
		
	}
	@PostMapping("/signup")
	public String signup(UserVO user,RedirectAttributes rttr)
	{
		log.info("signup..");
		service.insertUser(user);
		rttr.addFlashAttribute("result", user.getUserid());
		return "redirect:/user/User_Main_Home";
	}

}
