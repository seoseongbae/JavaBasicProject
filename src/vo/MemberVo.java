package vo;

import lombok.Data;

@Data
public class MemberVo {
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_bir;
	private String mem_tel;
	private String mem_add;
	private String mem_delyn;
	
	 @Override
	  public String toString() {
	      return "[회원 ID =" + mem_id + ", 회원 이름 =" + mem_name + ", "
	      		+ "회원 생년월일=" + mem_bir+ ", 회원 주소=" + mem_add + ", 회원 연락처    =" + mem_tel + ", "
	      		+ "]";
	   }
}
