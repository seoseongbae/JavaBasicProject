package vo;

import lombok.Data;

@Data
public class ProdJoinVo {
	private int pj_no;
	private int prod_no;
	private String mem_id;
	private String ac_no;
	@Override
	public String toString() {
		return "[가입번호 =" + pj_no + ", 상품번호=" + prod_no + ", "
				+ "회원 ID =" + mem_id + ", 계좌번호 =" + ac_no + "]";
	}
	
	
}
