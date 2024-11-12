package vo;

import lombok.Data;

@Data
public class BankVo {
	private int bank_no;
	private String bank_name;
	private String bank_point;
	private String bank_add;
	private String bank_tel;
	private String bank_region;
	
	@Override
	   public String toString() {
	      return "[지점번호 =" + bank_no + ", 은행명 =" + bank_name + ", 지점 =" + bank_point + ", "
	      		+ "상세주소 ="+ bank_add + ", 연락처 =" + bank_tel + ", 지역 =" + bank_region + "]";
	   }
	
}
