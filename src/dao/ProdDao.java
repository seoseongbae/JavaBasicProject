package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BankVo;
import vo.ProdJoinVo;
import vo.ProdVo;

public class ProdDao {
	private static ProdDao instance;

	private ProdDao() {

	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public List<ProdVo> memberProdList() {
		String sql="SELECT PROD_NO,PROD_NAME,SUBSTR(PROD_CONTENTS,1,10)AS PROD_CONTENTS,PROD_PRICE,PROD_RATE,PROD_SIGDATE,PROD_DIVISION "
				+ "FROM PRODUCT";
		return jdbc.selectList(sql,ProdVo.class);
	}

	public List<ProdVo> memberPordListDetail(List<Object> param) {
		String sql="SELECT PROD_NO,PROD_NAME,SUBSTR(PROD_CONTENTS,1,10)AS PROD_CONTENTS,PROD_PRICE,PROD_RATE,PROD_SIGDATE,PROD_DIVISION \r\n" + 
				"  FROM PRODUCT\r\n" + 
				" WHERE PROD_DIVISION=?";
		return jdbc.selectList(sql, param, ProdVo.class);
	}

	public void memberProdSign(List<Object> param) {
		String sql="DECLARE\r\n" + 
				"  new_ac_no VARCHAR2(20);\r\n" + 
				"BEGIN\r\n" + 
				"  SELECT SUBSTR(MAX(AC_NO), 1, 11) || TO_CHAR(TO_NUMBER(MAX(SUBSTR(AC_NO, -5))) + 1, 'FM00000')\r\n" + 
				"  INTO new_ac_no\r\n" + 
				"  FROM ACCOUNT;\r\n" + 
				"\r\n" + 
				"  INSERT INTO ACCOUNT VALUES (new_ac_no, ?, 0, SYSDATE, 1, ?, ?);\r\n" + 
				"END;";
		
		jdbc.update(sql, param);
	}

	public void memberProdSign_Join(List<Object> param2) {
		String sql="INSERT INTO PRODJOIN\r\n" + 
				"  VALUES ((SELECT NVL(MAX(PJ_NO)+1,1) FROM PRODJOIN),?,?,(SELECT MAX(AC_NO)FROM ACCOUNT))";
		jdbc.update(sql,param2);
	}

	public List<ProdJoinVo> memberProdJoin(List<Object> param) {
		String sql="SELECT PJ_NO,\r\n" + 
				"       PROD_NO,\r\n" + 
				"       MEM_ID,\r\n" + 
				"       AC_NO\r\n" + 
				"  FROM PRODJOIN\r\n" + 
				" WHERE MEM_ID = ?";
		return jdbc.selectList(sql, param, ProdJoinVo.class);
	}
	
}
