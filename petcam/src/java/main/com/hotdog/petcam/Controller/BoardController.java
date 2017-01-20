package com.hotdog.petcam.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotdog.petcam.Security.Auth;
import com.hotdog.petcam.Service.BoardService;
import com.hotdog.petcam.Service.CommentService;
import com.hotdog.petcam.VO.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired 
	private BoardService boardService;
	@Autowired
	private CommentService commentService;
	

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
	// ----->> 페이지와 검색 키워드는 뒤로가기시 콜백을 위해 사용한다.
	@Auth
	@RequestMapping("/view")
	public String view(@ModelAttribute BoardVo boardVo,Model model,
					   @RequestParam(value="page",required=true,defaultValue="1") Integer page,
					   @RequestParam(value="search",required=true,defaultValue="" )String search){
		
		model.addAttribute("boardVo", boardService.getView(boardVo.getBoard_no())); // @Modelattribute boardVo가 no를 포함한채 잘 들어왓나?
		model.addAttribute("commentList",commentService.getBoardComment(boardVo.getBoard_no())); // Comment 가져오기
		model.addAttribute("page", page);
		model.addAttribute("search",search);
		return "";
	}
}
