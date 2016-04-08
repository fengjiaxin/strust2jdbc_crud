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
	//转发
	public String dispatcher(){
		System.out.println("转发"+username);
		System.out.println("“转发"+password);
		return "success";
	}
	//重定向 session
	public String redirect(){
		ActionContext.getContext().getSession().put("username", username);
		ActionContext.getContext().getSession().put("password", password);
		System.out.println("重定向"+username);
		System.out.println("重定向"+password);
		return "success";
		
	}

}
