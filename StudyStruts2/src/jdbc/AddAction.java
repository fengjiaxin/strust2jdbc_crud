package jdbc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

public class AddAction extends ActionSupport{
	public String username;
	public String password;
	public String passwordss;
	public void setPasswordss(String passwordss) {
		this.passwordss = passwordss;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String execute() throws Exception{
		if(this.check()){
			if(password.equals(passwordss)){
				this.add();
				return "success";
			}
			else{
				String description="�û��������ڣ�����ע�ᵫ������������������벻һ��";
				System.out.println(description);
				ActionContext.getContext().getContextMap().put("desc", description);
				return "error";//�ض������ҳ��
			}
		}
		else{			
			String description="�û������Ѿ�����";
			System.out.println(description);
			ActionContext.getContext().getContextMap().put("desc", description);
			return "error";//�ض������ҳ��
		}

	}
	public void add() throws Exception{
		UserDao ud=new UserDao();
		User u=new User(username,password);
		System.out.println("��Ӹ��û�");
		ud.add(u);

	}
	public boolean check() throws Exception{
		UserDao ud=new UserDao();
		if(ud.getpassword(username)==null){ 
			return true;
		}
		else{	
			return false;
			}

	}

}
