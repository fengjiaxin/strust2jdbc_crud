package demo;

import com.opensymphony.xwork2.ActionSupport;

public class ValueAction extends ActionSupport {
	private String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	// Action��ҵ������
	public String vae_1() {
		System.out.println("UserAction.login()____1" + userName);
		
		return "success";
	}
	public String vae_2() {
		System.out.println("UserAction.login()____2" + userName);
		return "success";
	}
	public String execute(){
		System.out.println("Ĭ�ϵ�execute����");
		return SUCCESS;
	}
	

}
