package com.hotdog.petcam.VO;

public class Board_imageVo {
	private int image_no;
	private int board_no;
	
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "Board_imageVo [image_no=" + image_no + ", board_no=" + board_no + "]";
	}
	
	
}
