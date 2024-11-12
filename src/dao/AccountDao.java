package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.AccountVo;
import vo.TransVo;

public class AccountDao {
	private static AccountDao instance;

	private AccountDao() {

	}

	public static AccountDao getInstance() {
		if (instance == null) {
			instance = new AccountDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc=JDBCUtil.getInstance();

	public List<AccountVo> memberAccountSearch(List<Object> param) {//내 계좌 조회
		String sql="SELECT AC_NO,AC_PW,TO_CHAR(AC_OPDATE,'YYYY.MM.DD') as AC_OPDATE,AC_BALANCE,MEM_ID,PROD_NO\r\n" + 
				" FROM ACCOUNT\r\n" + 
				" WHERE MEM_ID=?\r\n" + 
				"   AND AC_STATE=1";
		return jdbc.selectList(sql, param, AccountVo.class);
	}

	public void memberAccountDelete(List<Object> param) {
		String sql="UPDATE ACCOUNT\r\n" + 
				"   SET AC_STATE=?\r\n" + 
				" WHERE MEM_ID=?"
				+ "AND AC_NO=?";
		
		jdbc.update(sql,param);
	}

	public void memberAccountDeposit1(List<Object> param) {
		String sql="INSERT INTO TRANS(TR_NO,AC_NO,TR_DIVISION,TR_PRICE,TR_DATE)\r\n" + 
				"   VALUES ((SELECT NVL(MAX(TR_NO)+1,0)FROM TRANS),?,?,?,SYSDATE)";
		jdbc.update(sql,param);
	}

	public void memberAccountDeposit2(List<Object> param2,int division) {
		String sql="";
		if(division==1) {
			sql ="UPDATE ACCOUNT\r\n" + 
				"   SET AC_BALANCE=AC_BALANCE+?\r\n" + 
				"   WHERE AC_NO=?";
		}
		else if(division==2||division==3) {
			sql ="UPDATE ACCOUNT\r\n" + 
					"   SET AC_BALANCE=AC_BALANCE-?\r\n" + 
					"   WHERE AC_NO=?";
		}
		jdbc.update(sql,param2);
	}
	public void memberAccountDeposit4(List<Object> param4) {
		String sql= "UPDATE ACCOUNT\r\n" + 
					"   SET AC_BALANCE=AC_BALANCE+?\r\n" + 
					" where AC_NO=?";
		jdbc.update(sql,param4);
	}

	public void memberAccountDeposit3(List<Object> param3, int division) {
	      String sql="";
	      if(division==1||division==2) {
	         sql="INSERT INTO DEPDRAW TR_NO\r\n" + 
	         		"(SELECT MAX(TR_NO)AS TR_NO \r\n" + 
	         		"  FROM TRANS \r\n" + 
	         		"  WHERE AC_NO=?\r\n" + 
	         		"    AND TR_DIVISION IN(1,2))";
	      }
	      else if(division==3) {
	         sql="INSERT INTO TRANSFER (TR_NO,AC_TNO)\r\n" + 
	         		"VALUES((SELECT MAX(TR_NO)AS TR_NO \r\n" + 
	         		"  FROM TRANS \r\n" + 
	         		"  WHERE AC_NO=?\r\n" + 
	         		"    AND TR_DIVISION =3),?)";
	      }
	      jdbc.update(sql,param3);
	   }

	public AccountVo accountPw(List<Object> paramac) {
		String sql="SELECT AC_NO,AC_PW,AC_BALANCE,TO_CHAR(AC_OPDATE,'YYYYMMDD')AS AC_OPDATE,AC_STATE,MEM_ID,PROD_NO FROM ACCOUNT\r\n" + 
				"				WHERE AC_NO=?\r\n" + 
				"                AND MEM_ID=?";
		 return jdbc.selectOne(sql, paramac,AccountVo.class);
	}

	public Map<String, Object> memberAccountChk(List<Object> param5) {
		String sql="SELECT AC_NO FROM ACCOUNT\r\n" + 
				"WHERE AC_NO=?";
		return jdbc.selectOne(sql, param5);
	}

	public List<TransVo> transSearch(List<Object> param) {
		String sql="SELECT TR_NO,AC_NO,TR_DIVISION,TR_PRICE,TO_CHAR(TR_DATE,'YYYYMMDD') AS TR_DATE FROM TRANS\r\n" + 
				" WHERE AC_NO=?";
		return jdbc.selectList(sql, param, TransVo.class);
	}
	   public List<TransVo> memberTransSearchDep(List<Object> param2) {
		      String sql="SELECT T.TR_NO,T.AC_NO,T.TR_DIVISION,T.TR_PRICE,TO_CHAR(T.TR_DATE,'YYYYMMDD') AS TR_DATE\r\n" + 
		            "  FROM TRANS T,DEPDRAW D,ACCOUNT A\r\n" + 
		            " WHERE T.TR_NO=D.TR_NO\r\n" + 
		            "   AND A.AC_NO=T.AC_NO\r\n" + 
		            "   AND T.TR_DIVISION IN(1,2)\r\n" + 
		            "   AND T.AC_NO=?";
		      return jdbc.selectList(sql,param2,TransVo.class);
		   }

		   public List<TransVo> memberTransSearchTra(List<Object> param3) {
		      String sql="SELECT T.TR_NO,T.AC_NO,T.TR_DIVISION,T.TR_PRICE,TO_CHAR(T.TR_DATE,'YYYYMMDD') AS TR_DATE,B.AC_TNO\r\n" + 
		            "  FROM TRANS T,TRANSFER B,ACCOUNT A\r\n" + 
		            " WHERE T.TR_NO=B.TR_NO(+)\r\n" + 
		            "   AND A.AC_NO=T.AC_NO\r\n" + 
		            "   AND T.TR_DIVISION =3\r\n" + 
		            "   AND T.AC_NO=?";
		      return jdbc.selectList(sql,param3,TransVo.class);
		   }
		   
		   
		   
		   
}
