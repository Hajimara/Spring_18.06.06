package org.yogiyo.app.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.yogiyo.app.service.domain.UserVO;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * Service가 실행되기 전 호출되는 method
		 * request에 해당하는 session을 가져온다. session이 없으면 boolean타입으로 session create여부를 정의한다.
		 * */
		HttpSession httpSession = request.getSession(true);
		
		UserVO user = (UserVO) httpSession.getAttribute("user");
		System.out.println("user 정보 : "+ user);
		
		// getRequestURI : requset URL 을 query string을 decode 하지 않고 읽어옴.
		String urii = request.getRequestURI();
		System.out.println("interceptor uri 확인 : " +urii);

		// ========= Method 해석 = Interceptor를 통해 request 가 handler로 들어오기 전 session을 확인하고
				// user Object에 String "user" 로 session 을 저장된 session 을 불러와 session 정보가 있다면
				// uri변수에 request에서의 URI 를 저장한다.

				// request.getRequestDispatcher("/index.jsp").forward(request, response);
				// =========요청한 requset를 받아 Dispatcher의 handler에게 mapping parameter의 값으로 mapping
				// 요청을 함. forward방식으로 req,res 인자도 함께 보낸다.
		

		if(user != null) {
			String uri = request.getRequestURI();
			
			if(uri.indexOf("login") != -1) {
				System.out.println("login 상태입니다...");
				System.out.println("interceptor.getRequestURI Check....!" + uri);
				
				request.getRequestDispatcher("WEB-INF/views/main/main.jsp").forward(request, response);
				
				return false;
			}
			return true;
			
		}else {
			//비로그인
			
			String uri = request.getRequestURI();
			
			if(uri.indexOf("login") != -1) {
				System.out.println("uri : "+ uri);
				
				return true;
			}
			
			System.out.println("비로그인..." );
			request.getRequestDispatcher("WEB-INF/views/user/login.jsp").forward(request, response);
			
			return false;
			
		}
		
	}

	
	
	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	

}
