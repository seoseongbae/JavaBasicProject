package controller;

import java.util.*;

import print.Print;
import service.AdminService;
import service.MemberService;
import util.ScanUtil;
import util.View;
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

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	AdminService adminService = AdminService.getInstance();
	MemberService memberService = MemberService.getInstance();
	boolean login = false;
	String id = null;
	int count = 0;

	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case ADMIN:
				view = admin();
				break;
			case ADMIN_LOGOUT:
				view = adminLogout();
				break;
			case ADMIN_BOARD:
				view = adminBoard();
				break;
			case ADMIN_BOARD_UPDATE:
				view = adminBoardUpdate();
				break;
			case ADMIN_BOARD_ADD:
				view = adminNoticeAdd();
				break;
			case ADMIN_BPARD_DELETE:
				view = admiNoticeDelete();
				break;
			case MEMBER:
				view = member();
				break;
			case MEMBER_MAIN:
				view = memberMain();
				break;
			case MEMBER_LOGIN:
				view = memberLogin();
				break;
			case MEMBER_LOGOUT:
				view = memberLogout();
				break;
			case MEMBER_ID_PW_FIND:
				view = memberFind();
				break;
			case MEMBER_ID:
				view = memberID();
				break;
			case MEMBER_PW:
				view = memberPW();
				break;
			case MEMBER_SIGN:
				view = memberSign();
				break;
			case MEMBER_BOARD:
				view = memberBoard();
				break;
			case BOARD_CHECK:
				view = boardCheck();
				break;
			case BOARD_DET_CHECK:
				view = boardDetCheck();
				break;
			case BOARD_ADD:
				view = boardAdd();
				break;
			case BOARD_COMMENT:
				view = boardComment();
				break;
			case BOARD_COM_SEARCH:
				view = boardComSearch();
				break;
			case BOARD_COM_DELETE:
				view = boardComDelete();
				break;
			case BOARD_MYCONTENT:
				view = boardMyContent();
				break;
			case BOARD_MYCONTENT_LIST:
				view = boardMyContentList();
				break;
			case BOARD_MYLIST:
				view = boardMyList();
				break;
			case BOARD_MYLIST_DETAIL:
				view = boardMyListDetail();
				break;
			case BOARD_MYCONTENT_UPDATE:
				view = boardMyContentUpdate();
				break;
			case BOARD_MYCONTENT_DELETE:
				view = boardMyContentDelete();
				break;
			case MEMBER_UPDATE:
				view = memberUpdate();
				break;
			case MEMBER_UPDATE_PP:
				view = memberUpdatePp();
				break;
			case MEMBER_UPDATE_PW:
				view = memberUpdatePw();
				break;
			case MEMBER_UPDATE_PHONE:
				view = memberUpdatePhone();
				break;
			case MEMBER_DEL:
				view = memberDel();
				break;
			case MEMBER_RESERVE_MAIN:
				view = memberReserve();
				break;
			case MEMBER_RESERVE:
				view = reserveBank();
				break;
			case MEMBER_RESERVE_BANK:
				view = memberReserveBank();
				break;
			case MEMBER_RESERVE_SEARCH:
				view = memberReserveSearch();
				break;
			case MEMBER_RESERVE_DELETE:
				view = memberReserveDelete();
				break;
			case RESERVE_REGION:
				view = reserveRegion();
				break;
			case RESERVE_POINT:
				view = reservePoint();
				break;
			case MEMBER_ACCOUNT_SEARCH:
				view = memberAccountSearch();
				break;
			case MEMBER_ACCOUNT_TRANSACTION:
				view = memberAccountTransaction();
				break;
			case MEMBER_ACCOUNT_DEPOSIT:
				view = memberAccountDeposit();
				break;
			case MEMBER_ACCOUNT_WITHDRAW:
				view = memberAccountWithdraw();
				break;
			case MEMBER_ACCOUNT_TRANSFER:
				view = memberAccountTransfer();
				break;
			case MEMBER_ACCOUNT_DELETE:
				view = memberAccountDelete();
				break;
			case MEMBER_ACCOUNT_TRANS_SEARCH:
				view = memberTransSearch();
				break;
			case MEMBER_PROD:
				view = memberProd();
				break;
			case MEMBER_PRODSIGN:
				view = memberProdSign();
				break;
			case MEMBER_PRODLIST:
				view = memberProdList();
				break;
			case MEMBER_PRODLIST_DETAIL:
				view = memberProdListDetail();
				break;
			case MEMBER_PRODJOIN:
				view = memberProdJoin();
				break;
			case BOARD:
				view = board();
				break;
			case BOARD_DETAIL:
				view = boardDetail();
				break;
			default:
				break;
			}
		}
	}

	private View memberProdJoin() {// 가입내역확인
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [     상품 가입내역          ] ");
		List<Object> param = new ArrayList();
		param.add(sessionStorage.get("member"));
		List<ProdJoinVo> prodJoinVoList = memberService.memberProdJoin(param);
		for (ProdJoinVo prodJoinVo : prodJoinVoList) {
			System.out.println("\t\t\t\t\t  "+ prodJoinVo);
		}

		return View.MEMBER_PROD;
	}

	private View memberProdListDetail() {// 상세조회
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [    상품 구분별 조회        ] ");
		String prod = ScanUtil.nextLine("\t\t\t\t\t\t\t                   ▷ 조회할 상품을 입력해주세요 ex)입/출금,예금,적금  → ");
		int division;
		if (prod.equals("입/출금")) {
			division = 1;
			sessionStorage.put("division", division);
		} else if (prod.equals("예금")) {
			division = 2;
			sessionStorage.put("division", division);
		} else if (prod.equals("적금")) {
			division = 3;
			sessionStorage.put("division", division);
		}
		List<Object> param = new ArrayList();
		param.add(sessionStorage.remove("division"));
		List<ProdVo> prodListDetail = memberService.memberProdListDetail(param);
		for (ProdVo prodVo : prodListDetail) {
			System.out.println("\t\t  "+prodVo);
		}
		System.out.println("\t\t\t\t\t\t\t          1.상품 가입하기");
		System.out.println("\t\t\t\t\t\t\t          2.이전페이지");
        
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_PRODSIGN;
		case 2:
			return View.MEMBER_PROD;
		default:
			return View.MEMBER_PRODLIST;
		}
	}

	private View memberProdList() {// 전체조회
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [     상품 전체 조회         ] ");
		List<ProdVo> bankVo = memberService.memberProdList();
		for (ProdVo prodVo : bankVo) {
			System.out.println("\t\t  "+prodVo);
		}
		System.out.println("\t\t\t\t\t\t\t          1.상품 가입하기");
		System.out.println("\t\t\t\t\t\t\t          2.이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_PRODSIGN;
		case 2:
			return View.MEMBER_PROD;
		default:
			return View.MEMBER_PRODLIST;
		}
	}

	private View memberProdSign() {// 가입
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [      상품 가입             ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▶ 가입할 상품번호를 입력해주세요 → ");
		String yn = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 정말 가입하시겠습니까? (Y/N)");
		switch (yn) {
		case "Y":
			String acpw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌 비밀번호를 설정해주세요 → ");

			List<Object> param = new ArrayList();
			param.add(acpw);
			param.add(sessionStorage.get("member"));
			param.add(no);
			List<Object> param2 = new ArrayList();
			param2.add(no);
			param2.add(sessionStorage.get("member"));
			memberService.memberProdSign(param);
			memberService.memberProdSign_Join(param2);
			System.out.println("\t\t\t\t\t\t\t       → 상품이 가입되었습니다.");
		case "N":
			return View.MEMBER_PROD;
		default:
			return View.MEMBER_PRODSIGN;
		}
	}

	private View memberProd() { /* 상품 메인 */
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [      은행 상품             ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 상품 전체조회");
		System.out.println("\t\t\t\t\t\t\t          2. 구분별 조회");
		System.out.println("\t\t\t\t\t\t\t          3. 가입내역 확인");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_PRODLIST;
		case 2:
			return View.MEMBER_PRODLIST_DETAIL;
		case 3:
			return View.MEMBER_PRODJOIN;
		case 4:
			return View.MEMBER_MAIN;
		default:
			return View.MEMBER_PROD;
		}
	}

	private View memberTransSearch() {// 거래내역 전체조회
	      String no = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 조회 계좌번호 입력해주세요 ex)000-000000-00000 \n\t\t\t\t\t\t\t\t\t\t  → ");
	      int listNo=ScanUtil.nextInt("\t\t\t\t\t\t                1.전체조회  2.구분조회 → ");
	      switch (listNo) {
	      case 1: 
	         List<Object> param = new ArrayList();
	         param.add(no);
	         List<TransVo> transList = memberService.transSearch(param);
	         for (TransVo transVo : transList) {
	            System.out.println("\t\t      "+transVo);
	         }
	         break;
	      case 2: 
	         int listNoDe=ScanUtil.nextInt("\t\t\t\t\t\t                1.입/출금  2.이체 → ");
	         switch (listNoDe) {
	         case 1:
	            List<Object>param2=new ArrayList();
	            param2.add(no);
	            List<TransVo> transListDep=memberService.memberTransSearchDep(param2);
	            for (TransVo transVo : transListDep) {
	               System.out.println("\t\t      "+transVo);
	            }
	            break;
	         case 2:
	            List<Object>param3=new ArrayList();
	            param3.add(no);
	            List<TransVo> transListTran =memberService.memberTransSearchTra(param3);
	            for (TransVo transVo : transListTran) {
	               System.out.println("\t\t      "+transVo);
	            }
	            break;
	         default: break;
	         }
	      default: break;
	      }
	      
	      return View.MEMBER_ACCOUNT_TRANSACTION;
	   }

	/* 계좌 해지 */
	private View memberAccountDelete() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [      계좌 해지             ] ");
		String no=ScanUtil.nextLine("\t\t\t\t\t\t\t      ▷해지하실 계좌번호 입력하세요 →");
		String chk = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌를 해지하시겠습니까? → (Y/N)");
		List<Object> param = new ArrayList();
		param.add(2);
		param.add(sessionStorage.get("member"));
		param.add(no);
		switch (chk) {
		case "Y":
			memberService.memberAccountDelete(param);
			System.out.println("\t\t\t\t\t\t\t          → 계좌가 해지되었습니다.");
			return View.MEMBER_ACCOUNT_SEARCH;
		case "N":
			return View.MEMBER_ACCOUNT_SEARCH;
		default:
			return View.MEMBER_ACCOUNT_DELETE;
		}
	}

	/* 계좌 이체 */
	private View memberAccountTransfer() {
		List<Object> paramac = new ArrayList();
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [      계좌 이체             ] ");
		String no = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 이체할 계좌번호 입력하세요  ex)000-000000-00000 \n\t\t\t\t\t\t\t\t\t\t  → ");
		paramac.add(no);
		paramac.add(sessionStorage.get("member"));
		memberService.accountPw(paramac);
		int money = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 이체하실 금액 입력하세요 → ");
		int moneychk = (int) sessionStorage.get("accountbalance");
		while (true) {
			if (money > moneychk) {
				System.out.println("\t\t\t\t\t\t\t         → 계좌 잔고가 부족합니다.");
				money = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 이체하실 금액 입력하세요 → ");
			} else {
				break;
			}
		}
		String acno = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 이체받는 계좌번호 입력하세요  ex)000-000000-00000 \n\t\t\t\t\t\t\t\t\t\t    → ");
		String acpw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌비밀번호 입력 → ");
		while (true) {
			if (!acpw.equals(sessionStorage.get("accountpw"))) {
				System.out.println("\t\t\t\t\t\t\t       → 비밀번호가 일치하지 않습니다.");
				return View.MEMBER_ACCOUNT_SEARCH;
			} else {
				break;
			}
		}
		int division = 3;
		List<Object> param = new ArrayList();// 거래테이블 삽입 list
		param.add(no);
		param.add(division);
		param.add(money);
		List<Object> param2 = new ArrayList();// 계좌테이블 잔액변경 list 이체시 내 계좌 잔액마이너스
		param2.add(money);
		param2.add(no);
		List<Object> param4 = new ArrayList();// 계좌테이블 잔액변경 list 상대계좌 잔액 플러스
		param4.add(money);
		param4.add(acno);
		List<Object> param3 = new ArrayList();// 입출금/이체테이블 거래번호 ,상대계좌 삽입list;
		param3.add(no);
		param3.add(acno);
		List<Object> param5 = new ArrayList();// 계좌 확인
		param5.add(acno);
		memberService.memberAccountDeposit1(param);// 거래테이블 삽입
		memberService.memberAccountDeposit2(param2, division);// 계좌테이블 update
		memberService.memberAccountDeposit3(param3, division);// 입출금테이블
		boolean accountchk = memberService.memberAccountChk(param5);
		if (accountchk) {
			memberService.memberAccountDeposit4(param4);// 계좌테이블 update 상대계좌 잔액 플러스
		}

		printAccount();
		System.out.println("\t\t\t\t\t\t\t       → " + money + "원이 이체되었습니다.");
		return View.MEMBER_ACCOUNT_SEARCH;
	}

	/* 출금 */
	private View memberAccountWithdraw() {
		List<Object> paramac = new ArrayList();
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [       출금                 ] ");
		String no = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 출금하실 계좌번호 입력하세요  ex)000-000000-00000 \n\t\t\t\t\t\t\t\t\t\t    → ");
		paramac.add(no);
		paramac.add(sessionStorage.get("member"));
		memberService.accountPw(paramac);
		int money = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 출금하실 금액 입력하세요 → ");
		while (true) {
			if (money > (int) sessionStorage.get("accountbalance")) {
				System.out.println("\t\t\t\t\t\t\t       계좌 잔고가 부족합니다.");
				money = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 출금하실 금액 입력하세요 → ");
			} else {
				break;
			}
		}
		String acpw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌비밀번호 입력 → ");
		while (true) {
			if (!acpw.equals(sessionStorage.get("accountpw"))) {
				System.out.println("\t\t\t\t\t\t\t       → 비밀번호가 일치하지 않습니다.");
				return View.MEMBER_ACCOUNT_SEARCH;
			} else {
				break;
			}
		}
		int division = 2;
		List<Object> param = new ArrayList();// 거래테이블 삽입 list
		param.add(no);
		param.add(division);
		param.add(money);
		List<Object> param2 = new ArrayList();// 계좌테이블 잔액변경 list
		param2.add(money);
		param2.add(no);
		List<Object> param3 = new ArrayList();// 입출금테이블 거래번호 삽입list;
		param3.add(no);
		memberService.memberAccountDeposit1(param);// 거래테이블 삽입
		memberService.memberAccountDeposit2(param2, division);// 계좌테이블 update
		memberService.memberAccountDeposit3(param3, division);// 입출금테이블
		printAccount();
		System.out.println("\t\t\t\t\t\t\t       → " + money + "원이 출금되었습니다.");
		return View.MEMBER_ACCOUNT_SEARCH;
	}

	/* 입금 */
	/* 입금거래/입출금/계좌에 동시에 들어가야함. */
	private View memberAccountDeposit() {
		System.out.println("\t\t\t\t\t\t\t     [       입금                 ] ");
		int money = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 입금하실 금액 입력하세요 → ");
		String no = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 입금하실 계좌번호 입력하세요  ex)000-000000-00000 \n\t\t\t\t\t\t\t\t\t\t    → ");
		List<Object> paramac = new ArrayList();
		paramac.add(no);
		paramac.add(sessionStorage.get("member"));
		memberService.accountPw(paramac);
		String acpw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌비밀번호를 입력하세요 → ");
//		System.out.println(!acpw.equals(sessionStorage.get("accountpw")));
		while (true) {
			if (!acpw.equals(sessionStorage.get("accountpw"))) {
				System.out.println("\t\t\t\t\t\t\t       → 비밀번호가 일치하지 않습니다.");
				acpw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 계좌비밀번호를 입력하세요 → ");
			} else {
				break;
			}
		}
		int division = 1;
		List<Object> param = new ArrayList();// 거래테이블 삽입 list
		param.add(no);
		param.add(division);
		param.add(money);
		List<Object> param2 = new ArrayList();// 계좌테이블 잔액변경 list
		param2.add(money);
		param2.add(no);
		List<Object> param3 = new ArrayList();// 입출금테이블 거래번호 삽입list;
		param3.add(no);
		memberService.memberAccountDeposit1(param);// 거래테이블 삽입
		memberService.memberAccountDeposit2(param2, division);// 계좌테이블 update
		memberService.memberAccountDeposit3(param3, division);// 입출금테이블

		printAccount();
		System.out.println("\t\t\t\t\t\t\t       → " + money + "원이 입금되었습니다.");
		return View.MEMBER_ACCOUNT_SEARCH;
	}

	/* 거래 */
	private View memberAccountTransaction() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      계좌 거래             ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 입금");
		System.out.println("\t\t\t\t\t\t\t          2. 출금");
		System.out.println("\t\t\t\t\t\t\t          3. 이체");
		System.out.println("\t\t\t\t\t\t\t          4. 거래내역보기");
		System.out.println("\t\t\t\t\t\t\t          5. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_ACCOUNT_DEPOSIT;
		case 2:
			return View.MEMBER_ACCOUNT_WITHDRAW;
		case 3:
			return View.MEMBER_ACCOUNT_TRANSFER;
		case 4:
			return View.MEMBER_ACCOUNT_TRANS_SEARCH;
		default:
			return View.MEMBER_ACCOUNT_SEARCH;
		}
	}

	/* 내 계좌 조회 */
	private View memberAccountSearch() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     나의 계좌 조회         ] ");
		List<Object> param = new ArrayList();
		param.add(sessionStorage.get("member"));
		List<AccountVo> accountList = memberService.memberAccountSearch(param);
		for (AccountVo accountVo : accountList) {
			System.out.println("\t\t\t   "+accountVo);
		}
		System.out.println("\t\t\t\t\t\t\t          1. 계좌 거래");
		System.out.println("\t\t\t\t\t\t\t          2. 계좌 해지하기");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_ACCOUNT_TRANSACTION;
		case 2:
			return View.MEMBER_ACCOUNT_DELETE;
		case 3:
			return View.MEMBER_MAIN;
		default:
			return View.MEMBER_ACCOUNT_SEARCH;
		}
	}

	/* 회원정보수정 - 연락처 */
	/* //전화번호 업데이트 //같은 전화번호가 존재하면 다른값으로 입력. */
	private View memberUpdatePhone() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [  회원정보수정 - 연락처 변경  ] ");
		int count = 0;
		String phone = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 변경할 연락처 입력 ex)010-0000-0000 → ");
		List<MemberVo> memberlist = memberService.memberSearch();
		for (MemberVo memberVo : memberlist) {
			if (memberVo.getMem_tel().equals(phone)) {
				count++;
			}
		}
		while (true) {
			if (count != 0) {
				System.out.println("\t\t\t\t\t\t\t       → 전화번호가 존재합니다. 다른 비밀번호 입력해주세요.");
				return View.MEMBER_UPDATE_PHONE;

			} else {
				break;
			}
		}
		List<Object> param = new ArrayList();
		param.add(phone);
		param.add(sessionStorage.get("member"));
		memberService.memberUpdatePhone(param);
		System.out.println("\t\t\t\t\t\t\t       → 정보가 변경되었습니다.");
		return View.MEMBER_MAIN;
	}

	/* 비밀번호는 변경 //비밀번호는 고유값이 아니기 때문에 변경. */
	private View memberUpdatePw() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t   [ 회원정보수정 - 비밀번호 변경 ] ");
		String pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 변경할 비밀번호 입력 → ");
		while (true) {
			if (pw.equals(sessionStorage.get("mempw"))) {
				System.out.println("\t\t\t\t\t\t\t       → 비밀번호가 같습니다. 다른 비밀번호 입력해주세요.");
				pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 변경할 비밀번호 입력 → ");

			} else {
				break;
			}
		}
		List<Object> param = new ArrayList();
		param.add(pw);
		param.add(sessionStorage.get("member"));
		memberService.memberUpdatePw(param);
		sessionStorage.put("mempw", pw);
		System.out.println("\t\t\t\t\t\t\t       → 정보가 변경되었습니다.");
		return View.MEMBER_MAIN;
	}

	/* 회원정보수정- 휴대폰, 비밀번호 수정 */
	private View memberUpdatePp() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원정보수정           ] ");
		System.out.println("\t\t\t\t\t\t\t          1. PW 변경");
		System.out.println("\t\t\t\t\t\t\t          2. PHONE 변경");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_UPDATE_PW;
		case 2:
			return View.MEMBER_UPDATE_PHONE;
		case 3:
			return View.MEMBER_UPDATE;
		default:
			return View.MEMBER_UPDATE_PP;
		}
	}

	/* 회원 탈퇴 */
	private View memberDel() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      회원 탈퇴              ] ");
		String delyn=ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 정말 탈퇴하시겠습니까 (Y/N) → ");
		switch (delyn) {
		case "Y":
			List<Object> param = new ArrayList();
			param.add(delyn);
			param.add(sessionStorage.get("member"));
			memberService.memberDel(param);
			System.out.println("\t\t\t\t\t\t\t       → 탈퇴 완료되었습니다.");
			sessionStorage.remove("member");
			break;
		case "N":
			return View.MEMBER_UPDATE;
		default:
			return View.MEMBER_DEL;
		}
		return View.MAIN;
	}

	/* 회원 정보 수정 */
	private View memberUpdate() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원정보수정           ] ");
		// pw,tel만 수정하도록 코딩.
		String pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 비밀번호 입력 → ");
		while (true) {
			if (!pw.equals(sessionStorage.get("mempw"))) {
				System.out.println("\t\t\t\t\t\t\t       → 비밀번호가 일치하지 않습니다.");
				pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 비밀번호 입력 → ");
			} else {
				break;
			}
		}
		System.out.println("\t\t\t\t\t\t\t          1. 정보변경");
		System.out.println("\t\t\t\t\t\t\t          2. 회원탈퇴하기");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_UPDATE_PP;
		case 2:
			return View.MEMBER_DEL;
		case 3:
			return View.MEMBER_MAIN;
		default:
			return View.MEMBER_UPDATE;
		}
	}

	/* 예약 취소 */
	private View memberReserveDelete() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      예약 취소             ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷취소하실 번호를 입력해주세요 → ");
		String chk = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 예약을 취소하시겠습니까? (Y/N) → ");
		List<Object> param = new ArrayList();
		param.add(chk);
		param.add(no);
		param.add(sessionStorage.get("member"));
		switch (chk) {
		case "Y":
			memberService.memberReserveDelete(param);
			System.out.println("\t\t\t\t\t\t\t       → 예약이 취소되었습니다.");
		case "N":
			return View.MEMBER_RESERVE_SEARCH;
		default:
			return View.MEMBER_RESERVE_DELETE;
		}
	}

	/* 당일 예약 확인 */
	private View memberReserveSearch() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      예약 확인             ] ");
		List<Object> param = new ArrayList();
		param.add(sessionStorage.get("member"));
		List<ReserveVo> reserveList = memberService.memberReserveSearch(param);
		for (ReserveVo reserveVo : reserveList) {
			System.out.println("\t\t\t\t\t     " + reserveVo);
		}
		System.out.println("\t\t\t\t\t\t\t          1. 예약 취소하기");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_RESERVE_DELETE;
		case 2:
			return View.MEMBER_RESERVE_MAIN;
		default:
			return View.MEMBER_RESERVE_SEARCH;
		}
	}

	/* 예약 한 번 더 하기 */
	private View reserveBank() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [        예약                 ] ");
		String answer = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 예약하시겠습니까? (Y/N) → ");
		switch (answer) {
		case "Y":
			List<Object> param = new ArrayList();
			param.add(sessionStorage.get("member"));
			param.add(sessionStorage.remove("bankno"));
			memberService.reserveBank(param);
			System.out.println("\t\t\t\t\t                       → 예약이 완료되었습니다.");
		case "N":
			return View.MEMBER_RESERVE_MAIN;
		default:
			return View.MEMBER_RESERVE_MAIN;
		}
	}

	/* 지점별 검색 */
	private View reservePoint() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      지점별 검색            ] ");
		System.out.println("\t\t\t\t\t       (ex)하나은행 : 하, 하나, 하나은, 하나은행 4가지 예시 모두 가능");
		String point = "%";
		point += ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 지점 입력 → ");
		point += "%";
		List<Object> param = new ArrayList();
		param.add(point);
		List<BankVo> bankVo = memberService.reservePoint(param);
		printPoint(bankVo);
		System.out.println("\t\t\t\t\t\t\t          1. 예약");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 예약하실 은행 번호를 입력하세요 → ");
			sessionStorage.put("bankno", no);
			return View.MEMBER_RESERVE;
		case 2:
			return View.MEMBER_RESERVE_BANK;
		default:
			return View.RESERVE_REGION;
		}
	}

	/* 지역 검색 */
	private View reserveRegion() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     지역별 검색             ] ");
		printRegion();
		String region = ScanUtil.nextLine("\t\t\t\t\t\t\t                     ▷지역 입력 → ");
		List<Object> param = new ArrayList();
		param.add(region);
		List<BankVo> bankVo = memberService.reserveRegion(param);
		printRegion(bankVo);
		System.out.println("\t\t\t\t\t\t\t          1. 예약");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 예약하실 은행 번호를 입력하세요 → ");
			sessionStorage.put("bankno", no);
			return View.MEMBER_RESERVE;
		case 2:
			return View.MEMBER_RESERVE_MAIN;
		default:
			return View.RESERVE_REGION;
		}
	}

	/* 예약 메인 */
	private View memberReserveBank() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [       예약하기            ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 지역별 검색");
		System.out.println("\t\t\t\t\t\t\t          2. 지점별 검색");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.RESERVE_REGION;
		case 2:
			return View.RESERVE_POINT;
		case 3:
			return View.MEMBER_RESERVE;
		default:
			return View.MEMBER_RESERVE_BANK;
		}
	}

	/* 방문 예약 */
	private View memberReserve() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      방문 예약             ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 예약");
		System.out.println("\t\t\t\t\t\t\t          2. 예약확인");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_RESERVE_BANK;
		case 2:
			return View.MEMBER_RESERVE_SEARCH;
		case 3:
			return View.MEMBER_MAIN;
		default:
			return View.MEMBER_RESERVE_MAIN;
		}
	}

	/* 내가 등록한 게시글 삭제 */
	private View boardMyContentDelete() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    나의 게시글 삭제        ] ");
// 게시글이 없으면 존재하지 않는다 메시지
		if (!sessionStorage.containsKey("member")) {
			System.out.println("\t\t\t\t\t\t\t       → 게시글이 존재하지 않습니다.");
			return View.BOARD_MYLIST;
		}
		// 게시글이 있으면 삭제
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▷ 조회할 번호 입력 → ");
		List<Object> param = new ArrayList();
		param.add(no);

		memberService.myContentDelete(param);

		System.out.println("\t\t\t\t\t\t\t       → " + no + "번 게시글을 삭제했습니다.");
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_BOARD;
		case 2:
			return View.BOARD_MYCONTENT;
		default:
			return View.BOARD_MYCONTENT_DELETE;
		}
	}

	/* 내가 등록한 게시글 수정 */
	private View boardMyContentUpdate() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    나의 전체 게시글        ] ");
		/* 1. 게시판 글 중 내 게시판만 보이기 */
		String id = (String) sessionStorage.get("member");
		List<Object> param = new ArrayList();
		param.add(id);

		List<BoardVo> myList = memberService.myList(param);
		for (BoardVo boardVo : myList) {
			System.out.println("\t\t\t     " + boardVo);
		}

		/* 2. 게시글 번호 입력받기 */
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    나의 게시글 수정       ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▷ 수정할 게시글 번호를 입력하세요 → ");
		sessionStorage.put("boardNo", no);
		List<Object> param2 = new ArrayList();

		/* 3. 메뉴 고르고 수정하기 */
		System.out.println("\t\t\t\t\t\t\t          1. 제목");
		System.out.println("\t\t\t\t\t\t\t          2. 내용");
		System.out.println("\t\t\t\t\t\t\t          3. 전체 수정");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴을 선택하세요 → ");

		if (sel == 1 || sel == 3) {
			String title = ScanUtil.nextLine("\t\t\t\t\t\t\t                     ▷제목  → ");
			param2.add(title);
		}
		if (sel == 2 || sel == 3) {
			String content = ScanUtil.nextLine("\t\t\t\t\t\t\t                     ▷내용  → ");
			param2.add(content);
		}
		if (sel == 4) {
			return View.BOARD_MYCONTENT;
		}
		param2.add(no);
		memberService.boardMyContentUpdate(param2, sel);
		System.out.println("\t\t\t\t\t\t\t       →" + no + "번 게시글이 수정되었습니다.");

		return View.BOARD_MYLIST;
	}

	/* 내 게시글 상세보기 */
	private View boardMyListDetail() {
		printVar();
		/* 1. 게시판 글 중 내 게시판만 보이기 */
		String id = (String) sessionStorage.get("member");
		List<Object> param = new ArrayList();
		param.add(id);
		memberService.myList(param);

		/* 2. 게시판 목록 중 번호 입력 받고 입력받은 글로 상세보기 */

		System.out.println("\t\t\t\t\t\t\t     [    나의 상세 게시글         ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▷ 조회할 번호 입력 → ");
		sessionStorage.put("boardNo", no);
		List<Object> param2 = new ArrayList();
		param2.add(no);
		param2.add(id);

		List<BoardVo> boardList = memberService.myListDetail(param2);
		for (BoardVo boardVo : boardList) {
			System.out.println("\t\t\t     " + boardVo);
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_BOARD;
		case 2:
			return View.BOARD_MYCONTENT;
		default:
			return View.BOARD_MYLIST_DETAIL;
		}
	}

	/* 내 게시글 전체보기 */
	private View boardMyList() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    나의 전체 게시글        ] ");
		String id = (String) sessionStorage.get("member");
		List<Object> param = new ArrayList();
		param.add(id);
		memberService.myList(param);

		List<BoardVo> myList = memberService.myList(param);
		for (BoardVo boardVo : myList) {
			System.out.println("\t\t\t     " + boardVo);
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 나의 상세 게시글");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_MYLIST_DETAIL;
		case 2:
			return View.BOARD_MYCONTENT;
		default:
			return View.BOARD_MYLIST;
		}
	}

	/* 내 게시글 보기 */
	private View boardMyContentList() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    나의 게시글 조회         ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 나의 전체 게시글");
		System.out.println("\t\t\t\t\t\t\t          2. 나의 상세 게시글");
		System.out.println("\t\t\t\t\t\t\t          3. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_MYLIST;
		case 2:
			return View.BOARD_MYLIST_DETAIL;
		case 3:
			return View.MEMBER_BOARD;
		case 4:
			return View.BOARD_MYCONTENT;
		default:
			return View.BOARD_MYCONTENT_LIST;
		}
	}

	/* 내가 등록한 게시글 */
	private View boardMyContent() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [    내가 등록한 게시글      ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 나의 게시글 조회");
		System.out.println("\t\t\t\t\t\t\t          2. 나의 게시글 수정");
		System.out.println("\t\t\t\t\t\t\t          3. 나의 게시글 삭제");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_MYCONTENT_LIST;
		case 2:
			return View.BOARD_MYCONTENT_UPDATE;
		case 3:
			return View.BOARD_MYCONTENT_DELETE;
		case 4:
			return View.MEMBER_BOARD;
		default:
			return View.BOARD_MYCONTENT;
		}
	}

	/* 게시판 글 - 댓글 삭제 */
	private View boardComDelete() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [       댓글 삭제              ] ");
// 세션에서 댓글 있으면 삭제, 없으면 댓글이 존재하지 않는다고 출력하기 
		if (!sessionStorage.containsKey("member")) {
			System.out.println("\t\t\t\t\t\t\t       → 댓글이 존재하지 않습니다.");
			return View.BOARD_DET_CHECK;
		}
// 댓글이 있으면 삭제--댓글 리스트 출력 하고? 그러고 댓글 번호 입력하는 창 만들어서 추가해야함.
		int comno = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▷ 삭제할 댓글 번호 입력 → ");
		String id = (String) sessionStorage.get("member");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(comno);
		memberService.commentDelete(param); // 댓글 삭제

		System.out.println("\t\t\t\t\t\t\t       → " + id + "님의 댓글을 삭제했습니다.");
		printVar();
		System.out.println("\t\t\t\t\t\t\t       1. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t       2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_BOARD;
		case 2:
			return View.BOARD_DET_CHECK;
		default:
			return View.BOARD_COM_DELETE;
		}
	}

	/* 댓글 작성 */
	private View boardComment() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [       댓글 작성              ] ");
		String id = (String) sessionStorage.get("member");
		String content = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 내용 → ");

		List<Object> param = new ArrayList();
		param.add(sessionStorage.get("boardno"));
		param.add(id);
		param.add(content);

		memberService.CommentAdd(param);
		List<Object> param2 = new ArrayList();

// 댓글 추가 후 댓글 목록 출력 
		param2.add(sessionStorage.get("boardno"));
		List<CommentVo> commentList = memberService.commentList(param2); // commentList는 댓글 목록(중 저장된 회원 아이디 댓글목록)
		for (CommentVo commentVo : commentList) {
			System.out.println("\t\t\t     " + commentVo);
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_BOARD;
		case 2:
			return View.BOARD_DET_CHECK;
		default:
			return View.BOARD_COMMENT;
		}
	}

	/* 댓글 보기 */
	private View boardComSearch() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [        댓글                  ] ");
		int no = (int) sessionStorage.get("boardno");
		if (no != 0) { // null 체크 추가
			List<Object> param = new ArrayList<>();
			param.add(no);

			List<CommentVo> recomment = memberService.recomment(param);
			for (CommentVo commentVo : recomment) {
				System.out.println("\t\t\t     " + commentVo);
			}

		} else {
			System.out.println("\t\t\t\t\t\t\t       → 게시글 번호가 존재하지 않습니다.");
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 댓글 작성");
		System.out.println("\t\t\t\t\t\t\t          2. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_COMMENT;
		case 2:
			return View.MEMBER_BOARD;
		case 3:
			return View.BOARD_DET_CHECK;
		default:
			return View.BOARD_COM_SEARCH;
		}
	}

	/* 게시판 작성 */
	private View boardAdd() {
		List<BoardVo> boardListAdd = memberService.boardList();
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      게시판 작성             ] ");
		String title = ScanUtil.nextLine("\t\t\t\t\t\t                  1. 제목 → ");
		String content = ScanUtil.nextLine("\t\t\t\t\t\t                  2. 내용 → ");
		String id = (String) sessionStorage.get("member");

		List<Object> param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(id);
		memberService.boardListAdd(param);
		for (BoardVo boardVo : boardListAdd) {
			System.out.println("\t\t\t     " + boardVo);
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 게시판 목록");
		System.out.println("\t\t\t\t\t\t\t          2. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD;
		case 2:
			return View.MEMBER_BOARD;
		default:
			return View.BOARD_ADD;
		}
	}

	/* 게시판 상세 조회 */
	private View boardDetCheck() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     게시판 상세 조회         ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▷ 조회할 게시글 번호를 입력하세요 → ");

		List<Object> param = new ArrayList<Object>();
		param.add(no);

		List<BoardVo> boardList = memberService.boardListDetail(param); // 멤버서비스에서 상세조회 가져오기
		for (BoardVo boardVo : boardList) {
			System.out.println("\t\t\t     " + boardVo);
		}
		printVar();
		sessionStorage.put("boardno", no);
		System.out.println("\t\t\t\t\t\t\t          1. 댓글 보기");
		System.out.println("\t\t\t\t\t\t\t          2. 댓글 작성");
		System.out.println("\t\t\t\t\t\t\t          3. 댓글 삭제");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_COM_SEARCH;
		case 2:
			return View.BOARD_COMMENT;
		case 3:
			return View.BOARD_COM_DELETE;
		case 4:
			return View.MEMBER_BOARD;
		default:
			return View.BOARD_DET_CHECK;
		}
	}

	/* 게시판 전체 조회 */
	private View boardCheck() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     게시판 전체 조회       ] ");
		List<BoardVo> boardList = memberService.boardList();
		for (BoardVo boardVo : boardList) {
			System.out.println("\t\t\t     " + boardVo);
		}
		printVar();
		System.out.println("\t\t\t\t\t\t\t          1. 게시판 상세 조회");
		System.out.println("\t\t\t\t\t\t\t          2. 게시판 작성");
		System.out.println("\t\t\t\t\t\t\t          3. 내가 등록한 게시글");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_DET_CHECK;
		case 2:
			return View.BOARD_ADD;
		case 3:
			return View.BOARD_MYCONTENT;
		case 4:
			return View.MEMBER_BOARD;
		default:
			return View.BOARD_CHECK;
		}
	}

	/* 회원 게시판 */
	private View memberBoard() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      회원 게시판            ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 게시판 전체 조회");
		System.out.println("\t\t\t\t\t\t\t          2. 게시판 상세 조회");
		System.out.println("\t\t\t\t\t\t\t          3. 게시판 작성");
		System.out.println("\t\t\t\t\t\t\t          4. 내가 등록한 게시글");
		System.out.println("\t\t\t\t\t\t\t          5. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_CHECK;
		case 2:
			return View.BOARD_DET_CHECK;
		case 3:
			return View.BOARD_ADD;
		case 4:
			return View.BOARD_MYCONTENT;
		case 5:
			return View.BOARD;
		default:
			return View.MEMBER_BOARD;
		}
	}

	   /* 공지사항 상세보기 */
	   private View boardDetail() {
	      // 공지사항 전체보기 

	      List<NoticeVo> noticeVo = adminService.noticeList();
	      printnoticeList(noticeVo);
	      
	      // 공지사항 상세보기
	      
	      System.out.println("\t\t\t\t\t\t\t     [     공지사항 상세 조회       ] ");
	      int no = ScanUtil.nextInt("\t\t\t\t\t\t\t          ▷ 조회할 게시글 번호를 입력하세요 → ");
	      
	      List<Object> param = new ArrayList<Object>();
	      param.add(no);
	      
	      List<NoticeVo> boardDetail =memberService.boardDetail(param); // 관리자서비스에서 공지사항 상세보기 가져오기
	      for(NoticeVo noticeVo1 : boardDetail) {
	         System.out.println(noticeVo1);
	      }
	      return View.BOARD;
	   }

	/* 게시판 목록 */
	private View board() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      게시판 목록             ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 공지사항 게시판");
		System.out.println("\t\t\t\t\t\t\t          2. 회원 게시판");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.BOARD_DETAIL;
		case 2:
			return View.MEMBER_BOARD;
		case 3:
			return View.MEMBER_MAIN;
		default:
			return View.BOARD;
		}
	}

	/* 회원 회원가입 */
	private View memberSign() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원  회원가입          ] ");
		String id = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ ID → ");
		List<Object> chk = new ArrayList();
		chk.add(id);
		boolean idcheck = memberService.idCheck(chk);
		while (!idcheck) {
			chk.remove(id);
			if (!idcheck) {
				System.out.println("\t\t\t\t\t\t\t       → 존재하는 아이디 입니다.");
				id = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ ID → ");
			} else {
				break;
			}
			chk.add(id);
			idcheck = memberService.idCheck(chk);
		}

		String pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ PW → ");
		String name = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 이름 → ");
		String bir = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 생년월일 ex)1999-03-15 → ");
		String add = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 주소 → ");
		String tel = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 연락처 ex)010-1111-2222 → ");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		param.add(name);
		param.add(bir);
		param.add(add);
		param.add(tel);
		memberService.memberSign(param);
		System.out.println("\t\t\t\t\t\t\t       → 회원가입이 완료되었습니다.");
		return View.MEMBER;
	}

	/* 회원 비밀번호 찾기 */
	private View memberPW() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      회원 PW 찾기          ] ");
		String id = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ ID → ");
		String name = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 이름 → ");
		String tel = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 전화번호 입력 ex)010-1111-2222 → ");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(name);
		param.add(tel);
		Map<String, Object> pw = memberService.memberPw(param);
		System.out.println("\t\t\t\t\t\t\t       → PW는 : " + pw.get("MEM_PW") + "입니다");
		return View.MEMBER;
	}

	/* 회원 아이디 찾기 */
	private View memberID() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원 ID 찾기          ] ");
		String name = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 이름 → ");
		String tel = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 전화번호 입력 ex)010-1111-2222 → ");
		List<Object> param = new ArrayList();
		param.add(name);
		param.add(tel);
		Map<String, Object> id = memberService.memberId(param);
		System.out.println("\t\t\t\t\t\t\t       → ID는 : " + id.get("MEM_ID") + "입니다");
		return View.MEMBER;
	}

	/* 회원 아이디,비밀번호 찾기 메인 */
	private View memberFind() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원정보찾기            ] ");
		System.out.println("\t\t\t\t\t\t\t          1. ID 찾기");
		System.out.println("\t\t\t\t\t\t\t          2. PW 찾기");
		System.out.println("\t\t\t\t\t\t\t          3. 이전페이지");
		int sel = ScanUtil.menu();
		switch (sel) {
		case 1:
			return View.MEMBER_ID;
		case 2:
			return View.MEMBER_PW;
		case 3:
			return View.MEMBER;

		default:
			printdefault();
			return View.MEMBER_ID_PW_FIND;
		}
	}

	/* 회원 로그아웃 */
	private View memberLogout() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     회원 로그아웃           ] ");
		sessionStorage.remove("member"); // 회원 로그인 존재여부를 map에서 확인하는데 로그아웃하면서 지우는 과정.
		printEnd();
		return View.MAIN;
	}

	/* 회원 메인창 */
	private View memberMain() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      회원 메뉴              ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 상품");
		System.out.println("\t\t\t\t\t\t\t          2. 내 계좌 조회");
		System.out.println("\t\t\t\t\t\t\t          3. 게시판");
		System.out.println("\t\t\t\t\t\t\t          4. 방문예약");
		System.out.println("\t\t\t\t\t\t\t          5. 회원정보수정");
		System.out.println("\t\t\t\t\t\t\t          6. 로그아웃");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_PROD;
		case 2:
			return View.MEMBER_ACCOUNT_SEARCH;
		case 3:
			return View.BOARD;
		case 4:
			return View.MEMBER_RESERVE_MAIN;
		case 5:
			return View.MEMBER_UPDATE;
		case 6:
			return View.MEMBER_LOGOUT;
		default:
			return View.MEMBER_LOGIN;
		}
	}

	/* 회원 로그인 */
	private View memberLogin() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [      회원 로그인           ] ");
		boolean login = false;
		String id = null;
		String pw = null;
		if (!sessionStorage.containsKey("member")) { // map인 sessinstorage에 키(memberid) 값이 존재여부 확인
			id = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ ID → ");
			pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ PW → ");
			List<Object> param = new ArrayList();
			param.add(id);
			param.add(pw);
			login = memberService.login(param); // 관리자 서비스로 id,pw값 넘김
		}
		if (!login) {
			System.out.println("\t\t\t\t\t\t\t       → 다시 로그인 하세요");
			return View.MEMBER_LOGIN;
		} else {
			sessionStorage.put("member", id); // 로그인 되어있을때 관리자 아이디 출력하기 위해 값 넣어둠.
			sessionStorage.put("mempw", pw);// 회원정보 수정 및 탈퇴시 비밀번호 사용으로 인해 맵에 저장.
			System.out.println("\t\t\t\t\t\t\t       → " + sessionStorage.get("member") + "님 로그인 되었습니다.");
			return View.MEMBER_MAIN;
		}
	}

	/* 회원 홈 */
	private View member() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [        회원                 ] ");
		System.out.println("\t\t\t\t\t\t\t          1. 회원 로그인");
		System.out.println("\t\t\t\t\t\t\t          2. ID,PW 찾기");
		System.out.println("\t\t\t\t\t\t\t          3. 회원 가입");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                     ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.MEMBER_ID_PW_FIND;
		case 3:
			return View.MEMBER_SIGN;
		case 4:
			return View.MAIN;
		default:
			return View.MEMBER;
		}
	}

	/* 공지사항 삭제 */
	private View admiNoticeDelete() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     공지사항 삭제           ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▷ 삭제할 번호 입력 → ");
		List<Object> param = new ArrayList();
		param.add(no);
		adminService.noticeDelete(param);
		System.out.println("\t\t\t\t\t\t\t       → " + no + "번이 삭제되었습니다.");

		return View.ADMIN_BOARD;
	}

	/* 공지사항 작성 */
	private View adminNoticeAdd() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     공지사항 작성         ] ");
		String title = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 제목 → ");
		String content = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 내용 → ");
		String id = (String) sessionStorage.get("adid");
		List<Object> param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(id);
		adminService.noticeAdd(param);
		return View.ADMIN_BOARD;
	}

	/* 공지사항 변경 */
	private View adminBoardUpdate() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     공지사항 수정           ] ");
		int no = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▶수정할 번호를 입력하세요 → ");
		List<Object> param = new ArrayList();

		System.out.println("\t\t\t\t\t\t\t       1. 제목");
		System.out.println("\t\t\t\t\t\t\t       2. 내용");
		System.out.println("\t\t\t\t\t\t\t       3. 전체수정");
		System.out.println("\t\t\t\t\t\t\t       4. 이전페이지");
		int sel = ScanUtil.menu();
		if (sel == 1 || sel == 3) {
			String title = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 제목을 입력하세요 → ");
			param.add(title);
		}
		if (sel == 2 || sel == 3) {
			String content = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ 내용을 입력하세요 → ");
			param.add(content);
		}
		if (sel == 4) {
			return View.ADMIN_BOARD;
		}
		param.add(no);
		adminService.boardUpdate(param, sel);
		System.out.println("\t\t\t\t\t\t\t       → 변경 완료되었습니다.");

		return View.ADMIN_BOARD;
	}

	/* 공지사항 메인 */
	private View adminBoard() {
		List<NoticeVo> noticeVo = adminService.noticeList();
		printnoticeList(noticeVo);
		System.out.println("\t\t\t\t\t\t\t          1. 공지사항 작성");
		System.out.println("\t\t\t\t\t\t\t          2. 공지사항 변경");
		System.out.println("\t\t\t\t\t\t\t          3. 공지사항 삭제");
		System.out.println("\t\t\t\t\t\t\t          4. 이전페이지");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.ADMIN_BOARD_ADD;
		case 2:
			return View.ADMIN_BOARD_UPDATE;
		case 3:
			return View.ADMIN_BPARD_DELETE;
		case 4:
			return View.ADMIN;
		default:
			return View.ADMIN_BOARD;
		}
	}

	/* 관리자 로그아웃 */
	private View adminLogout() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t      [     관리자 로그아웃        ] ");
		sessionStorage.remove("adid");
		printEnd();
		return View.MAIN;
	}

	/* 관리자 로그인 */
	private View admin() {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [       관리자                ] ");
		if (!sessionStorage.containsKey("adid")) { // map인 sessinstorage에 키(adminid) 값이 존재여부 확인
			id = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ ID 를 입력하세요 → ");
			String pw = ScanUtil.nextLine("\t\t\t\t\t\t\t                    ▷ PW 를 입력하세요 → ");
			List<Object> param = new ArrayList();
			param.add(id);
			param.add(pw);
			login = adminService.login(param); // 관리자 서비스로 id,pw값 넘김
		}
		if (!login) {
			System.out.println("\t\t\t\t\t\t\t       → 다시 로그인 하세요");
			return View.ADMIN;
		} else {
			sessionStorage.put("adid", id); // 로그인 되어있을때 관리자 아이디 출력하기 위해 값 넣어둠.
			if (count == 0)
				System.out.println("\t\t\t\t\t\t\t       → " + sessionStorage.get("adid") + "님 로그인 되었습니다.");
			count++;

			System.out.println("\t\t\t\t\t\t\t          1. 공지사항");
			System.out.println("\t\t\t\t\t\t\t          2. 로그아웃");
			int sel = ScanUtil.menu();
			switch (sel) {
			case 1:
				return View.ADMIN_BOARD;
			case 2:
				return View.ADMIN_LOGOUT;
			default:
				return View.ADMIN;
			}
		}
	}

	/* 메인 홈페이지 */
	private View home() {
		printStart();
		System.out.println("\t\t\t\t\t\t\t          1. 관리자");
		System.out.println("\t\t\t\t\t\t\t          2. 회원");
		int sel = ScanUtil.nextInt("\t\t\t\t\t\t\t                    ▶ 메뉴를 선택하세요 → ");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.MEMBER;
		default:
			return View.MAIN;
		}
	}
}
