package com.hotdog.petcam.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotdog.petcam.Security.Auth;
import com.hotdog.petcam.Service.BlogService;
import com.hotdog.petcam.Service.CommentService;
import com.hotdog.petcam.Service.ImageService;
import com.hotdog.petcam.Service.PostService;

@Controller
public class BlogController {

	@Autowired private BlogService blogService;
	@Autowired private PostService postService;
	@Autowired private ImageService imageService;
	@Autowired private CommentService commentService;
	
	
	//  블로그 메인에 들어갈때 파라미터로 year,month 를 받아서 글 리스트를 보여주도록 한다.
	@RequestMapping("/{nickname}")
	public String main(@PathVariable String nickname, Model model,
						@RequestParam(value="y",required=true,defaultValue="") String year,
						@RequestParam(value="m",required=true,defaultValue="") String month){
		
		// 블로그 입장시 메인에 뿌릴 Map을 생성한다.
		Map<String, Object> map = new HashMap<String,Object>();
		
		// map에 Post List를  year, month로 뽕아내어 입력해둔다.
		map.put("blogMainPostList", postService.getBlogMainPostList(year,month));
		
		// map에 포스트들의 대표이미지를 가져와서 뿌릴 내용을 저장한다. 
		map.put("blogMainImageList", imageService.getBlogMainImageList(year,month));
		
		// 댓글리스트를 글 별로 분류해두고 글을 선택했을때 확인하도록..
		map.put("blogMainCommentList", commentService.getBlogMainCommentList(year,month));
		
		model.addAttribute("map", map);
	
		// Image List에는 매인이미지만 뿌리고 PostVo 전체가 다 넘어가 있으니 통신할 필요없이  사진 클릭했을때 글과 댓글만 뿌려주면 된다.
		return "blog/blog-main";
	}
	@Auth
	@RequestMapping("/{nickname}/post")
	public String write(@PathVariable String nickname ){
		return "blog/write";
	}
	
	
	
	@Auth
	@RequestMapping("/{nickname}/vod")
	public String vod(@PathVariable String nickname){
		return "blog/vod-main";
	}
	
	@Auth
	@RequestMapping("/{nickname}/streaming")
	public String Streaming(@PathVariable String nickname){
		return "blog/streaming-main";
	}
	
	@Auth
	@RequestMapping("/{nickname}/account")
	public String Account(@PathVariable String nickname){
		return "blog/account-main";
	}
	
	
}
