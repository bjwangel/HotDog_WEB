package com.hotdog.petcam.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotdog.petcam.VO.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 기본,검색 시 전체 post개수를 구함
	public int getTotalCount(int searchGroup,int category,String search){
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("searchGroup", searchGroup);
		map.put("search", search);
		map.put("category", category);
		return sqlSession.selectOne("board.getTotalCount", map);
	}
	
	// view를 구성하기 위한 List를 뽑는다.
	public List<BoardVo> getList(int category,int searchGroup,String search,int page,int listSize){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("category", category);
		map.put("searchGroup", searchGroup);
		map.put("search", search);
		map.put("page", page);
		map.put("listSize", listSize);
		
		return sqlSession.selectList("board.getList", map);
	}
	
	public List<BoardVo> getMainBoardList(){
		return sqlSession.selectList("board.getMainBoardList");
	}
	
	public List<BoardVo> getMainNoticeList(){
		return sqlSession.selectList("board.getMainNoticeList");
	}
}
