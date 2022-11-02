package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.UserVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {com.example.config.RootConfig.class})
@Log4j
public class BoardMapperTest {
	
	//@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private UserMapper umapper;
	
	
	//@Test
	public void getList()
	{
		umapper.getList().forEach(user -> log.info(user));
	}
	//@Test
	public void Insert()
	{
			UserVO user= new UserVO();
			user.setUserid("4444");
			user.setPassword("4444");
			user.setAuth(1);
			user.setMobile("1231231231235");
			user.setAddress("busan2");
			user.setName("lee");
			umapper.insertUser(user);
			log.info(user);
	}
	//@Test
	public void Delete()
	{
		log.info("DELETE COUNT : " + umapper.delete("521"));
	}
	@Test
	public void login()
	{
		UserVO user= new UserVO();
		user=umapper.LoginUser("521","4321");
		log.info(user);
	}
	//@Test
		public void Update()
		{
			UserVO user= new UserVO();
			//실행전 존재하는 번호인지 확인 할 것

			user.setUserid("521");
			user.setName("mmm");
			
			int count = umapper.update(user);
			log.info("UPDATE COUNT :" +count);
		}
	
	
	//@Test
	public void testGetList()
	{
		//BoardMapper.java의 getList에서 board의 데이터 타입이 전해져버려서
		//별도로 타입을 지정할 필요가 없다.
		mapper.getList().forEach( board -> log.info(board));
	}
	//@Test
	public void testInsert()
	{
		BoardVO board= new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		log.info(board);
	}
	
	//@Test
	public void testInsertSelectKey()
	{
		BoardVO board= new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		log.info(board);
	}
	
	//@Test
	public void testRead()
	{
		//존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(2L);
		log.info(board);
	}
	
	//@Test
	public void testDelete()
	{
		log.info("DELETE COUNT : " + mapper.delete(6L));
	}
	//@Test
	public void testUpdate()
	{
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인 할 것
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT :" +count);
	}
	
	//@Test
	public void testPaging()
	{
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
