package com.hotdog.petcam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotdog.petcam.Security.Auth;
import com.hotdog.petcam.Service.AccountService;

@Auth
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired 
	private AccountService accountService;
	
	@RequestMapping("/prevmodify")
	public Object prevModify(){
		
	}
	
	@RequestMapping("/modify")
	public String basicModify(){
		return "";
	}

	@RequestMapping("/")
	public String profile(){
		return "";
	}
	
	@RequestMapping("/")
	public String myCommunity(){
		return "";
	}
}
