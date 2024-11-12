package vo;

import lombok.Data;

@Data
public class AccountVo {
	private String ac_no;
	private String ac_pw;
	private int ac_balance;
	private String ac_opdate;
	private String ac_state;
	private String mem_id;
	private int prod_no;
	
	@Override
	public String toString() {
		return "[계좌 번호 =" + ac_no + ", 계좌 개설일 =" + ac_opdate + ", "
				+ "잔액 ="+ ac_balance + ", 회원 ID=" + mem_id + ", 상품번호 =" + prod_no + "]";
	}
		//	계좌 상태 =" + ac_state + ","
}
