package vo;

import lombok.Data;

@Data
public class BoardVo {
	private int b_no;
	private String b_title;
	private String b_contents;
	private String b_reg_date;
	private String mem_id;
	
	@Override
	public String toString() {
		return "[게시판 번호 =" + b_no + ", 게시판 제목=" + b_title + ", 게시판 내용=" + b_contents + ", "
				+ "게시판 등록일시="+ b_reg_date + ", 회원 ID =" + mem_id + "]";
	   }
}
