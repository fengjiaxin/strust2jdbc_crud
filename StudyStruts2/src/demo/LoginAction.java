package demo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	public String username;
	public String password;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//ת��
	public String dispatcher(){
		System.out.println("ת��"+username);
		System.out.println("��ת��"+password);
		return "success";
	}
	//�ض��� session
	public String redirect(){
		ActionContext.getContext().getSession().put("username", username);
		ActionContext.getContext().getSession().put("password", password);
		System.out.println("�ض���"+username);
		System.out.println("�ض���"+password);
		return "success";
		
	}

}
