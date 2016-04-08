package test;

import java.sql.SQLException;

import jdbc.User;
import jdbc.UserDao;

public class Testdb {
	public static void main(String[] args) throws Exception {
		UserDao a=new UserDao();
		String m=a.getpassword("ÂíæçÒ¢");
		System.out.println(m);
		User b=a.findById(1);
		System.out.println(b.toString());
		
	}

}
