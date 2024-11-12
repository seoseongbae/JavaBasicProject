package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BankVo;
import vo.ReserveVo;

public class BankDao {
	private static BankDao instance;

	private BankDao() {

	}

	public static BankDao getInstance() {
		if (instance == null) {
			instance = new BankDao();
		}
		return instance;
	}
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public List<BankVo> reserveRegion(List<Object> param) {//지역검색
		String sql="SELECT *FROM BANK\r\n" + 
				" WHERE BANK_REGION=?";
		return jdbc.selectList(sql, param, BankVo.class);
	}

	public List<BankVo> reservePoint(List<Object> param) {//지점 검색
		String sql="SELECT *FROM BANK\r\n" + 
				"WHERE BANK_POINT LIKE ?";
		return jdbc.selectList(sql, param, BankVo.class);
	}

	public List<ReserveVo> memberReserveSearch(List<Object> param) {//당일 예약 확인
		String sql="SELECT RES_NO,MEM_ID,TO_CHAR(RES_DATE,'YYYYMMDD')AS RES_DATE,P_NO FROM RESERVE\r\n" + 
				" WHERE MEM_ID=?\r\n" + 
				"   AND TO_CHAR(RES_DATE,'YYYYMMDD')=TO_CHAR(SYSDATE,'YYYYMMDD')"
				+ " AND RES_DELYN='N'";
		return jdbc.selectList(sql, param, ReserveVo.class);
	}
	public void reserveBank(List<Object> param) {//예약
		String sql="INSERT INTO RESERVE (RES_NO,MEM_ID,P_NO)\r\n" + 
				"  VALUES((SELECT NVL(MAX(RES_NO)+1,0)FROM RESERVE),?,?)";
		jdbc.update(sql, param);
	}

	public void memberReserveDelete(List<Object> param) {//예약 취소
		String sql="UPDATE RESERVE\r\n" + 
				"  SET RES_DELYN=?\r\n" + 
				"  WHERE RES_NO=?\r\n" + 
				"  AND MEM_ID=?";
		jdbc.update(sql, param);
		
	}
	
}
