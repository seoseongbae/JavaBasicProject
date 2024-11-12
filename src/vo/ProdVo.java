package vo;

import lombok.Data;

@Data
public class ProdVo {
	private int prod_no;
	private String prod_name;
	private String prod_contents;
	private int prod_price;
	private int prod_rate;
	private int prod_sigdate;
	private int prod_division;
	
	@Override
	public String toString() {
		return "[상품번호=" + prod_no + ", 상품명=" + prod_name + ", 상품특징=" + prod_contents
				+ ", 상품가격 =" + prod_price + ", 금리 =" + prod_rate + ", 가입기간 =" + prod_sigdate
				+ ", 상품구분(1.입출금 | 2.예금  | 3.적금)=" + prod_division + "]";
	}
	

	
}
