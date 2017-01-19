package com.hotdog.petcam.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotdog.petcam.Service.BoardService;
import com.hotdog.petcam.Service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired BoardService boardService;
	@Autowired UserService userService;
	
	
	@RequestMapping("/")
	public String Main(HttpServletRequest request,Model model){
		
		// 1. 공통적인 리스트 뿌리기	
		model.addAttribute("mainBoardList",boardService.getMainBoardList());
		model.addAttribute("mainBoardList",boardService.getMainNoticeList());
		model.addAttribute("mainUserList", userService.getMainUserList());
		
		// 2. 로그인 연동 리스트 뿌리기
		model.addAttribute("MainMyUserList", userService.getMainMyUserList());
		
		
		return "main/index";
	}
	
}
