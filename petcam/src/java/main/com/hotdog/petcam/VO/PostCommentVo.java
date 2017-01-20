package com.hotdog.petcam.VO;

public class PostCommentVo {

	private int comment_no;
	private String content;
	private String regdate;
	private int post_no;
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
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "PostCommentVo [comment_no=" + comment_no + ", content=" + content + ", regdate=" + regdate
				+ ", post_no=" + post_no + ", user_no=" + user_no + "]";
	}
	
	
}
