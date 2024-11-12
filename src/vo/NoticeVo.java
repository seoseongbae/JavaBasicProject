package vo;

import lombok.Data;

@Data
public class NoticeVo {//공지사항VO
	private int nb_no;
	private String nb_title;
	private String nb_contents;
	private String nb_reg_date;
	private String admin_id;
	@Override
	public String toString() {
		return "[번호=" + nb_no + ", 제목=" + nb_title + ", 내용=" + nb_contents + ", 등록일="
				+ nb_reg_date+"]";
	}
	
}
