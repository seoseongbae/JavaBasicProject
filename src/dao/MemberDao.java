package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.AdminVo;
import vo.BoardVo;
import vo.CommentVo;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	JDBCUtil jdbc=JDBCUtil.getInstance();
	
	public Map<String, Object> memberId(List<Object> param) {
		String sql="SELECT MEM_ID FROM MEMBER\r\n" + 
				" WHERE MEM_NAME=?\r\n" + 
				"   AND MEM_TEL=?"+
				"   AND MEM_DELYN='N'";
		return jdbc.selectOne(sql, param);
	}
	public Map<String, Object> memberPw(List<Object> param) {
		String sql="SELECT MEM_PW FROM MEMBER\r\n" + 
				" WHERE MEM_ID=?\r\n" + 
				"   AND MEM_NAME=?\r\n" + 
				"   AND MEM_TEL =?"+
				"   AND MEM_DELYN='N'";
		return jdbc.selectOne(sql, param);
	}

	public void memberSign(List<Object> param) {
		String sql="INSERT INTO MEMBER (MEM_ID,MEM_PW,MEM_NAME,MEM_BIR,MEM_ADD,MEM_TEL)\r\n" + 
				"  VALUES (?,?,?,?,?,?)";
		jdbc.update(sql, param);
		
	}

	public MemberVo login(List<Object> param) {
		String sql="SELECT MEM_ID,MEM_PW,MEM_NAME,MEM_BIR,MEM_ADD,MEM_TEL FROM MEMBER\r\n" + 
				" WHERE MEM_ID=?\r\n" + 
				"   and MEM_PW=?"
				+ " AND MEM_DELYN='N'";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}

	public Map<String, Object> idCheck(List<Object> chk) {
		String sql="SELECT MEM_ID FROM MEMBER\r\n" + 
				" WHERE MEM_ID=?";
		return jdbc.selectOne(sql, chk);
	}

	public void memberDel(List<Object> param) {
		String sql="UPDATE MEMBER\r\n" + 
				"   SET MEM_DELYN=?\r\n" + 
				" WHERE MEM_ID=?";
		jdbc.update(sql,param);
		
	}
	
	public List<MemberVo> memberSearch() {
		String sql="SELECT MEM_TEL FROM MEMBER";
		return jdbc.selectList(sql,MemberVo.class);
	}
	
	public void memberUpdatePw(List<Object> param) {
		String sql="UPDATE MEMBER\r\n" + 
				"   SET MEM_PW=?\r\n" + 
				"WHERE MEM_ID=?";
		jdbc.update(sql, param);
		
	}

	public void memberUpdatePhone(List<Object> param) {
		String sql="UPDATE MEMBER\r\n" + 
				"   SET MEM_TEL=?\r\n" + 
				"WHERE MEM_ID=?";
		jdbc.update(sql, param);
		
	}

	
	// 여기부터 회원 게시판 거  -> 옮겨야 함 
	
	public List<BoardVo> boardList() {
		String sql="SELECT B_NO, SUBSTR(B_TITLE,0,10) AS B_TITLE, SUBSTR(B_CONTENTS,0,10) AS B_CONTENTS, TO_CHAR(B_REG_DATE, 'YYYY.MM.DD') AS B_REG_DATE , MEM_ID\r\n" + 
				   "FROM BOARD\r\n" + 
				   "WHERE B_DELYN ='N'\r\n" + 
				   "ORDER BY B_NO";
		return jdbc.selectList(sql,BoardVo.class);   
		
	}

	public List<BoardVo> boardListDetail(List<Object> param) {
		String sql="SELECT B_NO, B_TITLE, B_CONTENTS, TO_CHAR(B_REG_DATE, 'YYYY.MM.DD') AS B_REG_DATE , MEM_ID\r\n" + 
				   "FROM BOARD\r\n" + 
				   "WHERE B_NO = ?\r\n" + 
				   "AND B_DELYN = 'N'";
		return jdbc.selectList(sql,param,BoardVo.class);
	}

	public void boardListAdd(List<Object> param) {
		String sql="INSERT INTO BOARD (B_NO, B_TITLE, B_CONTENTS,  MEM_ID)\r\n" + 
				   "VALUES ( (SELECT NVL(MAX(B_NO)+1,0) FROM BOARD), ?, ?, ?)";
		jdbc.update(sql,param);
	}



	public void boardComment(List<Object> param) {
		String sql = "UPDATE COMMENTS \r\n" + 
				     "SET COM_DELYN = 'Y'\r\n" + 
				     "WHERE MEM_ID = ?";
		jdbc.update(sql,param);	
		}

	public void commentDelete(List<Object> param) {
		String sql = "UPDATE COMMENTS \r\n" + 
				"SET COM_DELYN = 'Y'\r\n" + 
				"WHERE MEM_ID = ?\r\n" + 
				"  AND COM_NO=?"; 
		
		jdbc.update(sql,param);		
	}

	public void CommentAdd(List<Object> param) {
		String sql ="INSERT INTO COMMENTS (COM_NO, B_NO, MEM_ID, COM_CONTENTS)\r\n" + 
				    "VALUES ((SELECT NVL(MAX(COM_NO) + 1, 0) FROM COMMENTS), ?, ?, ?)";
		
		jdbc.update(sql,param);	
	}

	public List<CommentVo> commentList(List<Object> param2) {
		String sql = "SELECT COM_NO, B_NO, MEM_ID, COM_CONTENTS\r\n" + 
					 "FROM COMMENTS\r\n" + 
					 "WHERE B_NO = ?"+
					 "AND COM_DELYN = 'N'"; 
		
		return jdbc.selectList(sql,param2,CommentVo.class);
	}

	public List<BoardVo> myList(List<Object> param) {
		String sql = "SELECT B_NO, B_TITLE, SUBSTR(B_CONTENTS,0,10) AS B_CONTENTS, TO_CHAR(B_REG_DATE, 'YYYY.MM.DD')AS B_REG_DATE, MEM_ID\r\n" + 
					 "FROM BOARD\r\n" + 
					 "WHERE MEM_ID = ?\r\n" + 
					 "AND B_DELYN = 'N'"; 
		return jdbc.selectList(sql,param,BoardVo.class);
	}

	public List<BoardVo> myListDetail(List<Object> param2) {
		String sql = "SELECT B_NO, B_TITLE, B_CONTENTS, TO_CHAR(B_REG_DATE, 'YYYY.MM.DD') AS B_REG_DATE , MEM_ID\r\n" + 
					 "FROM BOARD\r\n" + 
					 "WHERE B_NO = ?\r\n" + 
					 "AND MEM_ID = ?\r\n" + 
					 "AND B_DELYN = 'N'"; 
		return jdbc.selectList(sql,param2,BoardVo.class);
	}

	
	
	
	public void myContentDelete(List<Object> param) {
		String sql = "UPDATE BOARD\r\n" + 
					 "SET B_DELYN = 'Y'\r\n" + 
					 "WHERE B_NO = ? ";
		
		jdbc.update(sql,param);		
	}


	public List<BoardVo> myList() {
		String sql = "SELECT B_NO, B_TITLE, B_CONTENTS, TO_CHAR(B_REG_DATE, 'YYYY.MM.DD') AS B_REG_DATE , MEM_ID\r\n" + 
					 "FROM BOARD\r\n" + 
					 "WHERE B_NO = ?\r\n" + 
					 "AND MEM_ID = ?";
		return jdbc.selectList(sql,BoardVo.class);   
	}


	public void boardUpdate(List<Object> param2, int sel) {
		String sql = "UPDATE BOARD\r\n" + 
					 "SET ";
			if(sel == 1 || sel == 3) {
				sql += "B_TITLE = ?";
				if(sel == 3) {
					sql+= ", ";
				}
			}
			if(sel == 2 || sel == 3) {
				sql += "B_CONTENTS = ?";
				if(sel == 3) {
					sql += ", ";
				}
			}
			
			sql+= "B_REG_DATE = SYSDATE ";
			sql+= "WHERE B_NO = ?";

		jdbc.update(sql, param2);
	}

	public List<CommentVo> recomment(List<Object> param) {
		String sql = "SELECT B_NO, COM_NO, MEM_ID, COM_CONTENTS\r\n" + 
					 "FROM COMMENTS\r\n" + 
					 "WHERE B_NO = ?\r\n" + 
					 "AND COM_DELYN = 'N'";
		return jdbc.selectList(sql, param, CommentVo.class);   
	}



		
}
		

