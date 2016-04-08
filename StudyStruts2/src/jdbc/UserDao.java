package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {
	private  Connection conn ;
	private  PreparedStatement pstmt;
	private  ResultSet rs;

	public void add(User u)throws Exception{
		conn=Tools.getConnection();
		String sql="insert into person(name,password) values(?,?)";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);

		pstmt.setString(1, u.getName());
		pstmt.setString(2, u.getPassword());
		pstmt.executeUpdate();
		Tools.close(rs, pstmt, conn);


	}

	public void update(User u)throws SQLException{
		conn=Tools.getConnection();
		String sql = "update person set name=?,password=?£¬where id=?";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, u.getName());
		pstmt.setString(2, u.getPassword());
		pstmt.setInt(3, u.getId());
		pstmt.executeUpdate();
		Tools.close(rs, pstmt, conn);


	}
	public String getpassword(String name) throws Exception{
		String password=null;
		conn=Tools.getConnection();
		String sql="select password from person where name=?";
		pstmt =(PreparedStatement)conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs=pstmt.executeQuery();
		if(rs.next()){
			password=rs.getString(1);
		}
		Tools.close(rs, pstmt, conn);
		return password;
	}


	public void delete(int id)throws SQLException{
		conn=Tools.getConnection();
		String sql = "delete from person where id=?";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, id);  
		pstmt.executeUpdate();
		Tools.close(rs, pstmt, conn);


	}


	public User findById(int id) throws Exception {
		User u= new User();
		conn=Tools.getConnection();
		String sql = "select name,password from person where id=?";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		if(rs.next()){
			u.setName(rs.getString(1));
			u.setPassword(rs.getString(2));

		}
		Tools.close(rs, pstmt, conn);
		return u;


	}

	public Map<Integer,User>  findAll() throws SQLException {
		Map<Integer,User> persons=new HashMap<Integer, User>();
		conn=Tools.getConnection();
		String sql = "select id,name,password from person";
		pstmt = (PreparedStatement) conn.prepareStatement(sql);

		rs=pstmt.executeQuery();

		while(rs.next()){
			User p=new User();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPassword(rs.getString(3));
			persons.put(rs.getInt(1), p);
		}
		Tools.close(rs, pstmt, conn);
		return persons;	  
	}



}
