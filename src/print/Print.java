package print;

import java.util.List;

import vo.BankVo;
import vo.NoticeVo;

public class Print {
	public void printVar() {
		System.out.println(
				"=================================================================================================================================================");
	}

	public void printnoticeList(List<NoticeVo> noticeList) {
		printVar();
		System.out.println("\t\t\t\t\t\t\t     [     공지사항 게시판        ] ");
		for (NoticeVo noticeVo : noticeList) {
			System.out.println("\t\t\t\t\t     "+noticeVo);
		}
		printVar();
	}

	public void printLogin() {
		System.out.println("\t\t\t\t\t\t\t        → ID, PW는 4자 이상 15자 이하로 입력해주세요.");
	}

	public void printdefault() {
		System.out.println("\t\t\t\t\t\t\t        → 아무것도 입력되지 않았습니다. 다시 입력해주세요.");
	}

	public void printRegion(List<BankVo> regionList) {
		printVar();
		for (BankVo bankVo : regionList) {
			System.out.println("\t "+bankVo);
		}
		printVar();
	}

	public void printPoint(List<BankVo> pointList) {
		printVar();
		for (BankVo bankVo : pointList) {
			System.out.println("\t "+bankVo);
		}
		printVar();
	}

	public void printStart() {
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀ ⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⢀");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀ ⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣜⢮⡳⣝⣕");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀ ⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢳⡳⣝⢮⣺");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠞⠮⠳⠁");

		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⡰⣝⢝⡕⡗⣖⢆⢦⢤⢄⡄⣄⣀⣀⡀⣀⢀⡀⣀⣀⢠⣀⢄⢤⢤⢔⡔⣖⢝⡎⣗⠝⠊");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠸⣪⢳⡹⡪⣎⢗⢽⡸⣕⢽⡸⡪⡮⡺⣪⢳⡹⣜⢮⢺⡸⡕⣗⢕⠧⡫⠊⠃⠁");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠈⠳⡹⡪⣎⢗⡕⡧⡳⣕⢝⢮⢪⠫⠎⠧⠫⠚⠘⠑⠉⠈⠈");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀ ⠀⠁⠁⠁⠁⠁⠁⠀⠀⣀⡠⡤⡤⡤⣀⡀");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡪⡮⡺⡪⣇⢯⣪⢺⣢⡀");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢳⢕⡝⡮⡳⢕⢧⢳⢕⡕⣗⠄");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢕⢧⡫⡎⠀⠀⠈⢪⡳⡹⣜⡅");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠨⡳⡕⣗⢕⠀⠀⠀⢸⢪⡫⣎⠎");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠑⠝⠼⠑⠀⠀⠀⢸⢕⢽⡸⠁");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣪⢳⢕⡍");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢗⡝⡎");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⣕⠝");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠋⠂");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⣄⡀⠀⣄⡀⣄⣄⣄⡄⢠⣠⣠⣀⠀⠀⢀⣀⣤⣄⡀⢤⡄⠀⣀⡀⠀⠀⢤⡄⠀⠀⣠⡴⣄⡀⠀⣀⣦⡄⡠⣤⢠⡄");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀  ⠀⠀⠀⠀⠀⣿⢅⣼⠟⠀⣿⣍⣈⠁⢸⣏⡈⣿⠂⠀⢈⣾⠉⢺⡌⢼⡧⡄⣿⡂⠀⠀⢺⡧⡄⠸⣽⠀⢸⡇⠀⣽⠎⣿⡑⣿⢺⡇");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀  ⠀⠀⠀⠀⣿⠝⣷⡄⠀⣿⡊⠉⠀⢸⡏⠉⣻⡆⠀⠘⣷⠀⣸⡏⢼⡇⠀⣿⢄⢀⢀⣹⡇⠰⢴⡽⠷⠿⠵⠴⠙⠧⢟⣴⠛⣾⡇");
		System.out.println("\t\t\t\t\t⠀⠀⠀⠀⠀ ⠀⠀⠀  ⠀⠀⠀⠛⠅⠈⠛⠂⠛⠛⠛⠃⠘⠛⠛⠙⠁⠀⠀⠈⠋⠁⠀⢺⡇⠀⠈⠉⠉⠉⢼⡇⠀⢺⣇⣀⣀⣀⡀⠀⠀⠸⣧⡀⣼⠇");

		System.out.println("\n" + "\n");
		System.out.println(
				"=================================================================================================================================================");
		System.out.println("\t\t\t\t\t\t        < 모두의 기쁨, 그 하나를 위하여, 하나은행 >");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t     [ 사용자 정보를 입력해주세요 ] ");

	}

	public void printEnd() {
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t       → 로그아웃 되었습니다.");
		System.out.println();
		System.out.println("\t\t\t\t\t\t        < 이용해주셔서 감사합니다. 좋은 하루 보내세요! >");
	}

	public void printAccount() {
		System.out.println("\t\t\t\t\t\t\t        ⠀⠀⠀⠀⠀⠀⠀⠀⡤⠒⡑⢁⠓⠒⢤");
		System.out.println("\t\t\t\t\t\t\t        ⠀⠀⠀⠀⠀⠀⢠⠋⠄⠂⡔⠗⡤⢁⠂⠹⡄");
		System.out.println("\t\t\t\t\t\t\t        ⠀⠀⠀⠀⠀⠀⣞⠠⠁⠌⠧⡥⡨⠐⠈⠄⡳");
		System.out.println("\t\t\t\t\t\t\t        ⠀⠀⠀⠀⠀⠀⢪⠠⢁⠂⣆⢂⡹⠀⠅⢂⡏");
		System.out.println("\t\t\t\t\t\t\t           ⠀⠀  ⠀  ⠈⠳⣀⠂⡈⠇⠅⠡⡨⡎");
		System.out.println("\t\t\t\t\t\t\t        ⠀⢠⠦⠴⢤⢐⣀⡠⡈⠓⠒⠖⠕⠙⠁");
		System.out.println("\t\t\t\t\t\t\t        ⠀⢸⠨⡘⢼⠈⡐⢈⢈⠙⠒⡒⠲⠒⠦⡄⣠⡰⠲⢙⡲⡀");
		System.out.println("\t\t\t\t\t\t\t        ⠀⢜⠌⢌⢮⠐⡀⢂⠐⡈⢐⠲⠕⠮⠦⠯⢂⢤⠳⠃⠁");
		System.out.println("\t\t\t\t\t\t\t        ⠀⣺⣈⢢⢳⠔⠲⠢⢦⣐⣀⠂⡂⢂⡰⡔⠙");
		System.out.println("\t\t\t\t\t\t\t        ⠀⠈⠈⠉⠁⠀⠀⠀⠀⠀⠈⠉⠊⠁⠁");
	}

	public void printRegion() {
		System.out.println("\t\t\t\t\t     [서울/경기/충남/충북/대전/광주/인천/전남/전북/경남/경북/강원/제주로 입력하세요.]");
	}

}
