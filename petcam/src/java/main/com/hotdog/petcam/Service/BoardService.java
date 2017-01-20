package com.hotdog.petcam.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotdog.petcam.Repository.BoardDao;
import com.hotdog.petcam.VO.BoardVo;

@Service
public class BoardService {
	private static final int LIST_SIZE= 10;
	private static final int PAGE_SIZE= 10;
	
	@Autowired  BoardDao boardDao;
	
	// 메인 사이트 게시판 리스트 ... ( 블로그의 경우 검색조건 대신 공개여부를 파라미터로 받아야한다.)
	public Map<String,Object> getTotalList(int category,int searchGroup,String search,int page){
		
		// page 계산을 위해 전체 리스트 개수 구하기
		int totalCount = boardDao.getTotalCount(searchGroup,category,search);   // 요청 조건에 따른 전체 Post 개수
		int pageCount= (int)Math.ceil((double)totalCount / LIST_SIZE);
		int blockCount = (int)Math.ceil( (double)pageCount / PAGE_SIZE );
		int currentBlock = (int)Math.ceil( (double)page / PAGE_SIZE );
		
		//파라미터 page 값  검증
				if( page < 1 ) {
					page = 1;
					currentBlock = 1;
				} else if( page > pageCount ) {
					page = pageCount;
					currentBlock = (int)Math.ceil( (double)page / PAGE_SIZE );
				}
				
		// view에서 페이지 리스트를 렌더링 하기위한 데이터 값 계산
		int beginPage = currentBlock == 0 ? 1 : (currentBlock - 1)*PAGE_SIZE + 1;
		int prevPage = ( currentBlock > 1 ) ? ( currentBlock - 1 ) * PAGE_SIZE : 0;
		int nextPage = ( currentBlock < blockCount ) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = ( nextPage > 0 ) ? ( beginPage - 1 ) + LIST_SIZE : pageCount;
		
		// TotalCount 계산했던 리스트에서 View로 만들 리스트 가져오기 
		List<BoardVo> list = boardDao.getList(category,searchGroup,search,page,LIST_SIZE);
		
		// 맵에 데이터 저장
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("page", page);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("search", search);
		map.put("searchGroup", searchGroup);
		map.put("category", category);
		map.put("listSize", LIST_SIZE);
		
		return map;
	}
	// 글 가져오기 
	public BoardVo getView(int board_no){
		return boardDao.getView(board_no);
	}
	
	
	// Main page를 위한 List 뽑아오기
	public List<BoardVo> getMainBoardList(){
		return boardDao.getMainBoardList();
		
	}
	public List<BoardVo> getMainNoticeList(){
		return boardDao.getMainNoticeList();
	}

}
