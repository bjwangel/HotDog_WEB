package com.hotdog.petcam.VO;

public class PostVo {
	private int post_no;
	private String title;
	private String content;
	private String regdate;
	private String post_image;
	private int publish;
	private int user_no;
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getPost_image() {
		return post_image;
	}
	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}
	public int getPublish() {
		return publish;
	}
	public void setPublish(int publish) {
		this.publish = publish;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", post_image=" + post_image + ", publish=" + publish + ", user_no=" + user_no + "]";
	}
	
	
}
