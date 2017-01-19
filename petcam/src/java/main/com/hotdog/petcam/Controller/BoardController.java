package com.hotdog.petcam.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotdog.petcam.Service.BoardService;
import com.hotdog.petcam.VO.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired 
	private BoardService boardService;

	// Board 메인, 페이징처리 ,검색 리스트 담당
	@RequestMapping("/")
	public String getTotalList(
			@RequestParam ( value="category", required=true,defaultValue="1") Integer category,
			@RequestParam ( value="searchgroup", required=true,defaultValue="1") Integer searchGroup,
			@RequestParam( value="search",required=true,defaultValue="") String search,
			@RequestParam( value="page",required=true,defaultValue="1") Integer page,
			Model model){
		
		Map<String,Object> map = boardService.getTotalList(category,searchGroup,search,page);
		model.addAttribute("map", map);
		return "";
	}
	
	// 게시판 리스트에 BoardVo 뿌려져 있으니까 model 하나 받아와서 뷰 구성 ( 댓글도 뿌리고 ajax 통신 )
	@RequestMapping("/view")
	public String view(@ModelAttribute BoardVo boardVo,Model model){
		
		return "";
	}
}
