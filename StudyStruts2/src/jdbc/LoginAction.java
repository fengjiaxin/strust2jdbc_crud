package jdbc;

import java.sql.SQLException;

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
	public String execute() throws Exception{
		System.out.println("拿到用户输入的name"+username);
		System.out.println("“拿到用户输入的密码"+password);
		//*需要处理用户输入的密码是否正确
		String username1=username.trim();
		String password1=password.trim();
		String pd=jdbc(username1);
		if(pd.equals("用户名字输入不正确")){
			return "error";
		}
		else if(password1.equals(pd)){		
			return "success";
		}
		else{
			return "error";
		}
	}
	//拿到db中密码的函数
	private  String jdbc(String name) throws Exception{
		String pd1=null;
		UserDao dao=new UserDao();			
		String pd=dao.getpassword(name);
		if (pd!=null){
			pd1=pd;
		}else{				 
			System.out.println("不对的name"+name);			
			return "用户名字输入不正确";	
		}
		return pd1;

	}



}
