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
		 * Service�� ����Ǳ� �� ȣ��Ǵ� method
		 * request�� �ش��ϴ� session�� �����´�. session�� ������ booleanŸ������ session create���θ� �����Ѵ�.
		 * */
		HttpSession httpSession = request.getSession(true);
		
		UserVO user = (UserVO) httpSession.getAttribute("user");
		System.out.println("user ���� : "+ user);
		
		// getRequestURI : requset URL �� query string�� decode ���� �ʰ� �о��.
		String urii = request.getRequestURI();
		System.out.println("interceptor uri Ȯ�� : " +urii);

		// ========= Method �ؼ� = Interceptor�� ���� request �� handler�� ������ �� session�� Ȯ���ϰ�
				// user Object�� String "user" �� session �� ����� session �� �ҷ��� session ������ �ִٸ�
				// uri������ request������ URI �� �����Ѵ�.

				// request.getRequestDispatcher("/index.jsp").forward(request, response);
				// =========��û�� requset�� �޾� Dispatcher�� handler���� mapping parameter�� ������ mapping
				// ��û�� ��. forward������� req,res ���ڵ� �Բ� ������.
		

		if(user != null) {
			String uri = request.getRequestURI();
			
			if(uri.indexOf("login") != -1) {
				System.out.println("login �����Դϴ�...");
				System.out.println("interceptor.getRequestURI Check....!" + uri);
				
				request.getRequestDispatcher("WEB-INF/views/main/main.jsp").forward(request, response);
				
				return false;
			}
			return true;
			
		}else {
			//��α���
			
			String uri = request.getRequestURI();
			
			if(uri.indexOf("login") != -1) {
				System.out.println("uri : "+ uri);
				
				return true;
			}
			
			System.out.println("��α���..." );
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
