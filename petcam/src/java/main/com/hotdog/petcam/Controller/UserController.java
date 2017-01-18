package com.hotdog.petcam.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotdog.petcam.DTO.JSONResult;
import com.hotdog.petcam.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired 
	private UserService userService;
	
	@RequestMapping("/test")
	public String test(){
		return "user/joinform2";
	}
	
	
	// 코드 체크 
	@ResponseBody
	@RequestMapping("/checkcode")
	public JSONResult test2(@RequestParam( value="id", required=true, defaultValue="" ) int inputCode,
							HttpServletRequest request){
		int code=(int)request.getSession().getAttribute("code");
		return JSONResult.success(userService.checkCode(inputCode,code)? "yes":"no");
	}
}
