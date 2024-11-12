package dao;

import java.util.List;
import util.JDBCUtil;
import vo.AdminVo;
import vo.NoticeVo;

public class adminDao {
	private static adminDao instance;

	private adminDao() {

	}

	public static adminDao getInstance() {
		if (instance == null) {
			instance = new adminDao();
		}
		return instance;
	}
	JDBCUtil jdbc=JDBCUtil.getInstance();
	
	public AdminVo login(List<Object> param) {
		String sql="SELECT * \r\n" + 
				"  FROM ADMIN\r\n" + 
				" WHERE ADMIN_ID=?\r\n" + 
				"   and ADMIN_PW=?";
		return jdbc.selectOne(sql, param, AdminVo.class);
	}

	public List<NoticeVo> noticeList() {
		String sql="SELECT NB_NO,\r\n" + 
				   "       SUBSTR(NB_TITLE,0,10) AS NB_TITLE,\r\n" + 
				   "       SUBSTR(NB_CONTENTS,0,10) AS NB_CONTENTS,\r\n" + 
				   "       TO_CHAR(NB_REG_DATE,'YYYY.MM.DD') AS NB_REG_DATE\r\n" + 
				   "FROM NOTICE \r\n" + 
				   "WHERE NB_DELYN='N'"+
				   "ORDER BY NB_NO";
		return jdbc.selectList(sql, NoticeVo.class);
	}

	public void noticeAdd(List<Object> param) {
		String sql="INSERT INTO NOTICE(NB_NO,NB_TITLE,NB_CONTENTS,ADMIN_ID)\r\n" + 
				" VALUES((SELECT NVL(MAX(NB_NO)+1,0) FROM NOTICE),?,?,?)";
		jdbc.update(sql,param);
	}

	public void noticeDelete(List<Object> param) {
		String sql="update NOTICE\r\n" + 
				"   set NB_DELYN='Y'\r\n" + 
				"WHERE NB_NO=?";
		jdbc.update(sql,param);
	}

	public void boardUpdate(List<Object> param,int sel) {
		String sql="UPDATE NOTICE\r\n" + 
				"SET ";
		if(sel==1||sel==3) {
			sql+="NB_TITLE=?,";
		}
		if(sel==2||sel==3) {
			sql+="NB_CONTENTS=?,";
		}		
		sql+="NB_REG_DATE=SYSDATE ";
		sql+="WHERE NB_NO=?";
		jdbc.update(sql, param);
	}
	
	public List<NoticeVo> noticeDetail(List<Object> param) {
		String sql = "SELECT NB_NO,\r\n" + "       NB_TITLE, \r\n" + "       NB_CONTENTS,\r\n"
				+ "       TO_CHAR(NB_REG_DATE,'YYYY.MM.DD') AS NB_REG_DATE,\r\n" + "       ADMIN_ID \r\n"
				+ "  FROM NOTICE \r\n" + " WHERE NB_DELYN = 'N'\r\n" + "   AND NB_NO = ?";
		return jdbc.selectList(sql, param, NoticeVo.class);
	}
}
