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
	//ת��
	public String execute() throws Exception{
		System.out.println("�õ��û������name"+username);
		System.out.println("���õ��û����������"+password);
		//*��Ҫ�����û�����������Ƿ���ȷ
		String username1=username.trim();
		String password1=password.trim();
		String pd=jdbc(username1);
		if(pd.equals("�û��������벻��ȷ")){
			return "error";
		}
		else if(password1.equals(pd)){		
			return "success";
		}
		else{
			return "error";
		}
	}
	//�õ�db������ĺ���
	private  String jdbc(String name) throws Exception{
		String pd1=null;
		UserDao dao=new UserDao();			
		String pd=dao.getpassword(name);
		if (pd!=null){
			pd1=pd;
		}else{				 
			System.out.println("���Ե�name"+name);			
			return "�û��������벻��ȷ";	
		}
		return pd1;

	}



}
