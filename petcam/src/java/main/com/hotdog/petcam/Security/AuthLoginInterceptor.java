package com.hotdog.petcam.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hotdog.petcam.Service.UserService;
import com.hotdog.petcam.VO.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler /* handler Method*/ ) throws Exception {
		UserVo userVo=new UserVo();
//		System.out.println("------------>>>>> " + request.getRequestURI());
		
		userVo.setEmail(request.getParameter("email"));
		userVo.setPass_word(request.getParameter("password"));
		// 여기까지 request 정보를 받아서 컨테이너에 UserService를 사용해야한다.
		
		// Web Application Context 받아오기.. 컨테이너 사용 매개변수로  servlet context 를 전해줌
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		UserService userService = ac.getBean(UserService.class);

		
		
		// 데이터베이스에서 해당 UserVo 받아오기
		 UserVo userVo2=userService.login(userVo);
			if(userVo2==null){
				// 이메일과 비밀번호가 일치하지 않는경우 
				response.sendRedirect(request.getContextPath()+"/user/loginform?result=fail");
				return false;
			}
		
		// 인증처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo2);
		
		response.sendRedirect(request.getContextPath());
		
//		System.out.println("AuthLoginInterceptor.preHandle called");
		return false;
	}

	
}
