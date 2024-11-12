package vo;

import lombok.Data;

@Data
public class AdminVo {
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return "[ID =" + id + ", PW =" + pw + "]";
	}
	
	
}
