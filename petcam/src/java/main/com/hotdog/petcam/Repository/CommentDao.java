package com.hotdog.petcam.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.BoardCommentVo;
import com.hotdog.petcam.VO.PostCommentVo;

@Repository
public class CommentDao {

	@Autowired 
	private SqlSession sqlSession;
	
	// ****************** 게시판 관련 ***************
	// 게시판 글의 댓글을 가져온다.
	public List<BoardCommentVo> getBoardComment(int board_no){
		return sqlSession.selectList("comment.getBoardComment",board_no);
	}
	
	// ***************** 블로그 관련 **************
	public List<PostCommentVo> getDefaultBlogMainCommentList(){
		return sqlSession.selectList("comment.getBlogMainCommentList");
	}
	
	public List<PostCommentVo> getBlogMainCommentList(String year,String month){
		
		Map<String,String> date= new HashMap<String,String>();
		date.put("year", year);
		date.put("month",month);
		
		return sqlSession.selectList("comment.getBlogMainCommentList",date);
	}
}
