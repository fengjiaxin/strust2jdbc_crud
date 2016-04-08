package demo;

import com.opensymphony.xwork2.ActionSupport;

public class ValueAction extends ActionSupport {
	private String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	// Action中业务处理方法
	public String vae_1() {
		System.out.println("UserAction.login()____1" + userName);
		
		return "success";
	}
	public String vae_2() {
		System.out.println("UserAction.login()____2" + userName);
		return "success";
	}
	public String execute(){
		System.out.println("默认的execute方法");
		return SUCCESS;
	}
	

}
