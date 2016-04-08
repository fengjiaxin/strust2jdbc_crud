package jdbc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindpwAction extends ActionSupport{
	public String username;
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		UserDao ud=new UserDao();
		String pw=ud.getpassword(username);
		if(pw==null){
			return "error";
		}else{
			ActionContext.getContext().getSession().put("PASSWORD", pw);
			ActionContext.getContext().getSession().put("USERNAME", username);
			return "success";
	    }
	}

}
