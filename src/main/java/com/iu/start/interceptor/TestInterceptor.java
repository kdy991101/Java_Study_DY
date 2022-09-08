package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//
public class TestInterceptor extends HandlerInterceptorAdapter {

	//상속받은 메서드를 자기에 맞게 재정의
	
	//ds에서 컨트롤러로 넘어가는 사이에 있음
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return이 true면 controller로 실행 아니면 진행 X
		System.out.println("Controller진입 전");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("Controller에서 ds로 나가기 전");
	}
}
