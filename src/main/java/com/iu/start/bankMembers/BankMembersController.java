package com.iu.start.bankMembers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value="login.iu", method=RequestMethod.GET)
	public void login() throws Exception{
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO) throws Exception{
		bankMembersService.getlogin(bankMembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		return "redirect:../";
	}
	
//메서드명 join 죽소는 멤버의 조인이라는 주소가 들어오면 실행 선언 
	//get
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)//get방식만 받겠다~
	public String join() {
		System.out.println("get Join실행");
		return "member/join";
	}
	
	//post
	@RequestMapping(value = "/member/join.iu", method = RequestMethod.POST)//post방식만 받겠다~
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("post Join실행");

			int result  = bankMembersService.setJoin(bankMembersDTO);
			if(result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		return "member/login";
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

}