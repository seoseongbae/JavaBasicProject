package service;

import java.util.List;

import controller.MainController;
import dao.adminDao;
import vo.AdminVo;
import vo.NoticeVo;


public class AdminService {
	private static AdminService instance;

	private AdminService() {

	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}
	adminDao dao=adminDao.getInstance();
	
	public boolean login(List<Object> param) {
		AdminVo admin=dao.login(param);
		if(admin==null) {
			return false;
		}
		return true;
	}

	public List<NoticeVo> noticeList() {
		return dao.noticeList();
	}

	public void noticeAdd(List<Object> param) {
		dao.noticeAdd(param);
		
	}

	public void noticeDelete(List<Object> param) {
		dao.noticeDelete(param);
		
	}

	public void boardUpdate(List<Object> param,int sel) {
		dao.boardUpdate(param,sel);
	}
	
}
