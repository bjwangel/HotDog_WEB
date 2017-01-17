package com.hotdog.petcam.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hotdog.petcam.Service.UserService;
import com.hotdog.petcam.VO.UserVo;

public class AuthSignUpInterceptor2 extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		// 메일 인증 코드를 세션에서 꺼내어 확인
		int inputCode=(int)request.getAttribute("code");
		
		HttpSession session = request.getSession();
		
		if((int)session.getAttribute("code")==inputCode){
			// code 비교해서 같으면..회원가입 시켜준다.
			ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
			UserService userService = ac.getBean(UserService.class);
			
			// 여기서  화면 전환 없이 성공여부 알려줘야 하나 ??
			userService.join((UserVo)session.getAttribute("TempUser"));
		}
				
		return false;
	}
	

}
