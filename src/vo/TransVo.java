package vo;

import lombok.Data;

@Data
public class TransVo {
	private int tr_no;
	private String ac_no;
	private String tr_division;
	private int tr_price;
	private String tr_date;
	private String ac_tno;
	
//	@Override
//	public String toString() {
//		return "계좌 거래 [거래번호 =" + tr_no + ", 계좌번호 =" + ac_no + ", "
//				+ "거래구분(1.입금 | 2.출금  | 3.이체) =" + tr_division + ", "
//				+ "거래금액 ="+ tr_price + ", 거래일자=" + tr_date + "]";
//	   }
	
	@Override
	   public String toString() {
	   
	      if(ac_tno!=null) {
	         return "[거래번호=" + tr_no + ", 계좌번호=" + ac_no + ", 거래구분(1.입금 | 2.출금  | 3.이체)=" + tr_division + ",거래금액="
	               + tr_price + ", 거래날짜=" + tr_date + ", 상대계좌번호=" + ac_tno + "]";
	      }
	      if(ac_tno==null) {
	    	  return "[거래번호=" + tr_no + ", 계좌번호=" + ac_no + ", 거래구분(1.입금 | 2.출금  | 3.이체)=" + tr_division + ",거래금액="
	    			  + tr_price + ", 거래날짜=" + tr_date + "]";
	      }
	      return "[거래번호=" + tr_no + ", 계좌번호=" + ac_no + ", 거래구분(1.입금 | 2.출금  | 3.이체)=" + tr_division + ",거래금액="
          + tr_price + ", 거래날짜=" + tr_date + ", 상대계좌번호=" + ac_tno + "]";
	   }
	
	
}
