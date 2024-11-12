package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.AccountDao;
import dao.BankDao;
import dao.MemberDao;
import dao.ProdDao;
import dao.adminDao;
import vo.AccountVo;
import vo.BankVo;
import vo.BoardVo;
import vo.CommentVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.ProdJoinVo;
import vo.ProdVo;
import vo.ReserveVo;
import vo.TransVo;

public class MemberService {
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	MemberDao memberdao=MemberDao.getInstance();
	BankDao  bankdao=BankDao.getInstance();
	AccountDao accountDao=AccountDao.getInstance();
	ProdDao prodDao=ProdDao.getInstance();
	adminDao admindao = adminDao.getInstance();
	public Map<String, Object> memberId(List<Object> param) {//아이디 찾기
		return memberdao.memberId(param);
	}
	public Map<String, Object> memberPw(List<Object> param) {//비밀번호찾기
		return memberdao.memberPw(param);
	}

	public void memberSign(List<Object> param) {//회원가입
		memberdao.memberSign(param);
		
	}

	public boolean login(List<Object> param) {//로그인
		MemberVo member=memberdao.login(param);
		if(member==null) {
			return false;
		}
		return true;
	}

	public List<BankVo> reserveRegion(List<Object> param) {//지역검색
		return bankdao.reserveRegion(param);
	}
	
	public List<BankVo> reservePoint(List<Object> param) {
		
		return bankdao.reservePoint(param);
	}
	public boolean idCheck(List<Object> chk) {//mem_delyn이 n일때.
		Map<String, Object> check=memberdao.idCheck(chk);
		if(check == null) {
			return true;
		}
		return false;
	}

	public void memberDel(List<Object> param) {//회원탈퇴
		memberdao.memberDel(param);
		
	}

	public void memberUpdatePw(List<Object> param) {//비밀번호 찾기
		memberdao.memberUpdatePw(param);
		
	}

	public List<MemberVo> memberSearch() {//회원 전화번호 중복 여부 확인.
		return memberdao.memberSearch();
	}

	public void memberUpdatePhone(List<Object> param) {//전화번호 찾기
		memberdao.memberUpdatePhone(param);
	}

	public void reserveBank(List<Object> param) {//예약
		bankdao.reserveBank(param);
	}

	public List<ReserveVo> memberReserveSearch(List<Object> param) {//예약확인
		return bankdao.memberReserveSearch(param);
		
	}

	public void memberReserveDelete(List<Object> param) {//예약 취소
		bankdao.memberReserveDelete(param);
	}

	public List<AccountVo> memberAccountSearch(List<Object> param) {
		return accountDao.memberAccountSearch(param);
		
	}

	public void memberAccountDelete(List<Object> param) {//계좌 해지
		accountDao.memberAccountDelete(param);
		
	}

	public void memberAccountDeposit1(List<Object> param) {//거래테이블 삽입
		accountDao.memberAccountDeposit1(param);
		
	}

	public void memberAccountDeposit2(List<Object> param2, int division) {//계좌테이블 잔액변경
		accountDao.memberAccountDeposit2(param2, division);
		
	}

	public void memberAccountDeposit3(List<Object> param3, int division) {//입출금테이블 삽입
		accountDao.memberAccountDeposit3(param3,division);
		
	}
	public void memberAccountDeposit4(List<Object> param4) {
		accountDao.memberAccountDeposit4(param4);
	}
	public void accountPw(List<Object> paramac) {//계좌 비밀번호 찾기
		
		AccountVo accountVo=accountDao.accountPw(paramac);
		MainController.sessionStorage.put("accountpw", accountVo.getAc_pw());
		MainController.sessionStorage.put("accountbalance", accountVo.getAc_balance());
		accountDao.accountPw(paramac);
	}

	// 여기부터 회원 게시판 들어옴 -> 옮겨야 함 
	public List<BoardVo> boardList() {
		return memberdao.boardList();
	}

	public List<BoardVo> boardListDetail(List<Object> param) {
		return memberdao.boardListDetail(param);
	}

	public void boardListAdd(List<Object> param) {
		memberdao.boardListAdd(param);
		
	}


	public void boardComment(List<Object> param) {
		 memberdao.boardComment(param);
	}

	public void commentDelete(List<Object> param) {
		memberdao.commentDelete(param);
		
	}

	public void CommentAdd(List<Object> param) {
		memberdao.CommentAdd(param);
	}

	public List<CommentVo> commentList(List<Object> param2) {
		
		return memberdao.commentList(param2);
	}

	public List<CommentVo> recomment(List<Object> param) {
		return memberdao.recomment(param);
	}
	

	public List<BoardVo> myList(List<Object> param) {
		return memberdao.myList(param);
	}

	public List<BoardVo> myListDetail(List<Object> param2) {
		return memberdao.myListDetail(param2);
	}

	
	public void myContentDelete(List<Object> param) {
		memberdao.myContentDelete(param);
		
	}

	public void boardMyContentUpdate(List<Object> param2, int sel) {
		memberdao.boardUpdate(param2, sel);
		
		
		
	}

	public boolean memberAccountChk(List<Object> param5) {
		Map<String, Object> check=accountDao.memberAccountChk(param5);
		if(check == null) {
			return false;
		}
		return true;
		
	}

	public List<TransVo> transSearch(List<Object> param) {
		return accountDao.transSearch(param);
		
	}

	public List<ProdVo> memberProdList() {//전체 출력
		return prodDao.memberProdList();
	}

	public List<ProdVo> memberProdListDetail(List<Object> param) {
		return prodDao.memberPordListDetail(param);
		
	}

	public void memberProdSign(List<Object> param) {
		prodDao.memberProdSign(param);
		
	}

	public void memberProdSign_Join(List<Object> param2) {
		prodDao.memberProdSign_Join(param2);
	}


	public List<ProdJoinVo> memberProdJoin(List<Object> param) {
		return prodDao.memberProdJoin(param);
	}
	
	public List<NoticeVo> boardDetail(List<Object> param) {
		return admindao.noticeDetail(param);
   }
	   public List<TransVo> memberTransSearchDep(List<Object> param2) {
		      return accountDao.memberTransSearchDep(param2);
		      
		   }

		   public List<TransVo> memberTransSearchTra(List<Object> param3) {
		      return accountDao.memberTransSearchTra(param3);
		   }
	
}
