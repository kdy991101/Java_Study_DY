package com.iu.start.bankMembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankAccount.BankAccountService;


@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	
	@RequestMapping(value="login.iu", method=RequestMethod.GET)
	public void login() throws Exception{
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, BankMembersDTO bankMembersDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankMembersDTO = bankMembersService.getlogin(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		
		int result = 0;
		String message = "로그인 실패";
		String url="./login.iu";
		if(bankMembersDTO != null) {//null이 아니라면
			message = "로그인 성공";
			result = 1;
			url="../";
		}
//		result가 0이면 로그인 성공 1이면 실패
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		return mv;
	}
	
//메서드명 join 죽소는 멤버의 조인이라는 주소가 들어오면 실행 선언 
	//get
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)//get방식만 받겠다~
	public String join() {
		System.out.println("get Join실행");
		return "member/join";
	}
	
	//post
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)//post방식만 받겠다~
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("post Join실행");
			System.out.println("파일명" + photo);//파일 명이 옴
			System.out.println("업로드시 파일명" + photo.getOriginalFilename());//업로드할 떄 이름
			System.out.println("업로드할 때 파라미터 이름" + photo.getName());
			System.out.println("파일의 크기를 말함" + photo.getSize());
			
			int result  = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
			
		return "member/login";
	}
	@GetMapping("check.iu")
	public String getcheck() throws Exception{
		System.out.println("get check실행");
		return "member/check";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public String getSearchByID() throws Exception{
		System.out.println("get search실행");
		return "member/search";
		
	}
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public String getSearchByID(String search, Model mv) throws Exception{
		System.out.println("post search실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		mv.addAttribute("list", ar);
		return "member/list";
		
	}
	
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session) throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		System.out.println("myPage실행");
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto",bankMembersDTO);//회원의 기본정보 account정보들어가있음
		mv.setViewName("member/myPage");
		return mv;
	}
	
}
