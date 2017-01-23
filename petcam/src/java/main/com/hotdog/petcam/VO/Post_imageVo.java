package com.hotdog.petcam.VO;

public class Post_imageVo {
	private int image_no;
	private int post_no;
	
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "Post_imageVo [image_no=" + image_no + ", post_no=" + post_no + "]";
	}
	
	
}
