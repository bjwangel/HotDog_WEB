package com.hotdog.petcam.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotdog.petcam.DTO.JSONResult;
import com.hotdog.petcam.Security.Auth;
import com.hotdog.petcam.Service.UserService;
import com.hotdog.petcam.VO.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	// 유저 테스트용 페이지
	@RequestMapping("/test")
	public String test(){
		return "user/joinform2";
	}
	
	
	@RequestMapping("/login")
	public String login(){

		return "redirect:/";
	}
	
	@RequestMapping(value = "/join")
	public String join(@RequestParam( value="nickname", required=true, defaultValue="" ) String nickname,@ModelAttribute UserVo userVo,
			HttpServletRequest request){
	
		int users_no = userService.join(userVo);
		userVo.setUsers_no(users_no);
		
		userService.insert(userVo);
		return "redirect:/";
	}
	
	@Auth
	@RequestMapping("/logout")
	public String logout() {
		return "main/index";
	}
	
	// 코드 체크 
	@ResponseBody
	@RequestMapping("/checkcode")
	public Object test2(@RequestParam( value="code", required=true, defaultValue="" ) int inputCode,
							HttpServletRequest request){
		int code=(int)request.getSession().getAttribute("code");
		return JSONResult.success(userService.checkCode(inputCode,code)? "yes":"no");
	}
	
	
	//닉네임체크
	@ResponseBody
	@RequestMapping("/nickCheck")
	public Object nickCheck(@RequestParam( value="nickname", required=true, defaultValue="" ) String nickname,
							HttpServletRequest request){
		
		Boolean result = userService.nicknameCheck(nickname);
		return JSONResult.success(result? "yes":"no");
	}
	
}
