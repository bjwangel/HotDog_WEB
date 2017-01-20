package com.hotdog.petcam.VO;

public class BoardCommentVo {
	private int comment_no;
	private String content;
	private String regdate;
	private int board_no;
	private int user_no;
	
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "BoardCommentVo [comment_no=" + comment_no + ", content=" + content + ", regdate=" + regdate
				+ ", board_no=" + board_no + ", user_no=" + user_no + "]";
	}
	
	
}
