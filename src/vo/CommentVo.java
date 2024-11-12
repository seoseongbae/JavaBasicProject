package vo;

import lombok.Data;

@Data
public class CommentVo {
	private int com_no;
	private int b_no;
	private String mem_id;
	private String com_contents;
	
	@Override
	public String toString() {
		return 	
				"[댓글 번호=" + com_no + ", 게시판 번호 =" + b_no + ", 회원 ID=" + mem_id + ", "
				+ "댓글 내용="+ com_contents + "]";
	   }
}
