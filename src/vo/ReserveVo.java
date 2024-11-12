package vo;

import lombok.Data;

@Data
public class ReserveVo {
	private int res_no;
	private String mem_id;
	private int p_no;
	private String res_date;
	@Override
	public String toString() {
		return "[예약번호=" + res_no + ", 회원아이디=" + mem_id + ", "
				+ "지점번호=" + p_no + ", 예약일자=" + res_date + "]";
	}
	
	
	
}
