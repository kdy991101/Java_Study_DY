package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			return ;
		}
		
		//로그인 사용자이 id와dto의 작성자가 일치하는 가?
		
		//로그인 사용자 정보는 session에 있음
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		//dto
		Map<String, Object> map = modelAndView.getModel();
		
		 BoardDTO boardDTO = (BoardDTO) map.get("boardDTO");
		 
		 if(!bankMembersDTO.getUsername().equals(boardDTO.getWriter())) {
			 modelAndView.setViewName("common/result");
			 modelAndView.addObject("result", 1);
			 modelAndView.addObject("message", "작성자만 수정이 가능합니다.");
			 modelAndView.addObject("url", "./list.iu");
		 }
		
	}

}
