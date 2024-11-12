package util;

public enum View {
	MAIN,					// 기본화면
	
	
	ADMIN,					// 관리자
	ADMIN_LOGOUT,  			//관리자 로그아웃 설정페이지
	ADMIN_BOARD,        	//관리자 공지사항 작성페이지
	ADMIN_BOARD_UPDATE, 	//관리자 공지사항 변경
	ADMIN_BOARD_ADD,		//관리자 공지사항 작성
	ADMIN_BPARD_DELETE,		//관리자 공지사항 삭제
	
	
	
	
	
	
	MEMBER,					// 회원 처음
	MEMBER_LOGIN,			//회원 로그인
	MEMBER_MAIN,			//회원 
	MEMBER_SIGN,			//회원 회원가입
	MEMBER_ID_PW_FIND,   	//회원 ID,PW찾기 메인
	MEMBER_ID,				//회원 아이디 찾기
	MEMBER_PW,				//회원 비밀번호 찾기
	MEMBER_LOGOUT, 			//회원 로그아웃
	
	
	MEMBER_UPDATE, 			//회원정보수정
	MEMBER_UPDATE_PP,		//PW/PHONE변경
	MEMBER_UPDATE_PW,
	MEMBER_UPDATE_PHONE,
	MEMBER_DEL,				//회원 탈퇴
	
	
	MEMBER_PROD,		//상품메인
	MEMBER_PRODSIGN,	//상품구매
	MEMBER_PRODLIST,	//전체조회
	MEMBER_PRODLIST_DETAIL,//상세조회
	MEMBER_PRODJOIN,	//가입내역
	
	MEMBER_ACCOUNT_SEARCH, 	// 내 계좌 조회
	MEMBER_ACCOUNT_TRANSACTION,	//거래(입/출금,이체)
	MEMBER_ACCOUNT_DEPOSIT, //입금
	MEMBER_ACCOUNT_WITHDRAW, //출금
	MEMBER_ACCOUNT_TRANSFER,	//이체
	MEMBER_ACCOUNT_DELETE,	//계좌해지
	MEMBER_ACCOUNT_TRANS_SEARCH,//거래내역
	
	
	
	MEMBER_BOARD,			//회원 게시판
	BOARD_CHECK,			// 게시판 전체 조회
	BOARD_ADD,				// 게시판 작성
	BOARD_DET_CHECK, 		// 게시판 상세 조회
	BOARD_COMMENT,			// 댓글 작성
	BOARD_COM_SEARCH,		// 댓글 보기
	BOARD_COM_DELETE,		// 댓글 삭제
	BOARD_MYCONTENT,		// 내가 등록한 게시글
	BOARD_MYCONTENT_LIST, 	// 내가 등록한 게시글 보기
	BOARD_MYLIST,			// 내 게시물 전체보기
	BOARD_MYLIST_DETAIL,	// 내 게시물 상세보기
	BOARD_MYCONTENT_UPDATE,	// 내가 등록한 게시글 수정
	BOARD_MYCONTENT_DELETE, // 내가 등록한 게시글 삭제
	BOARD,
	BOARD_DETAIL,
	
	
	
	MEMBER_RESERVE_MAIN, 	//회원 방문예약
	MEMBER_RESERVE_BANK,	//예약하기
	MEMBER_RESERVE_SEARCH,   //예약조회
	MEMBER_RESERVE_DELETE, 	//예약 취소
	RESERVE_REGION,			//은행지역검색
	RESERVE_POINT,			//은행지점검색
	MEMBER_RESERVE,			//예약하기.
	
	
	
	
	
	
	
	
	
}
