package com.example.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;//404.505 에러/페이지가 있는지 없는지 관련
import org.springframework.http.ResponseEntity;//응답객체
import org.springframework.stereotype.Controller;//@Controller 사용하기 위해 사용(현재는)하기 위한 컴포넌트?
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.example.domain.SampleDTO;//객체
import com.example.domain.SampleDTOList;//객체 배열
import com.example.domain.TodoDTO;//

import lombok.extern.log4j.Log4j;//extern 파일이 다를떼?

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	@Test
	public void basic()
	{
		log.info("basic......");
	}
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet()
	{
		
		System.out.println("111");
		log.info("basic get......");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2()
	{
		log.info("basic get only get.......");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto)
	{
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age)
	{
		log.info("name : "+name);
		log.info("age : " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids)
	{
		log.info("ids:" + ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids)
	{
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list)
	{
		log.info("list dtos: "+ list);
		return "ex02Bean";
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	 * false)); }
	 */
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo)
	{
		log.info("todo: "+todo);
		return "ex02";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page)
	{
		log.info("dto " +dto);
		log.info("page: "+page);
		
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05()
	{
		log.info("/ex05.....");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06()//@RequestBody SampleDTO dto
	{
		log.info("/ex06......");
		SampleDTO dto = new SampleDTO();//위에서 매개변수 받으면 지워도됨.
		dto.setAge(10);//json 매개변수로 받아서 사용할예정
		dto.setName("홍길동");//위와 동일하다.
		return dto;
	}
	/*
	 * @GetMapping("/ex06") public @ResponseBody SampleDTO ex06(@RequestBody
	 * SampleDTO dto) { log.info("/ex06......"); return dto; }
	 */
	
	//중요
	@GetMapping("/ex07")//ex06의 수작업 버전 json
	public ResponseEntity<String> ex07()
	{
		log.info("/ex07.......");
		String msg="{\"name\": \"강감찬\"}";
		HttpHeaders header= new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8;");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload()
	{
		log.info("/exUpload.....");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files)
	{files.forEach(file -> {
		log.info("-----------------------");
		log.info("name: "+file.getOriginalFilename());
		log.info("size: "+ file.getSize());
	});
	}
}
