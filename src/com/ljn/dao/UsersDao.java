package com.ljn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ljn.db.DButil;
import com.ljn.model.Users;

public class UsersDao {
    public void add(Users u) throws SQLException {
    	String sql="insert into users(uname,truename,pwd,sex,cernum,mail,phone,datetime ) "
    			+ " values(?,?,?,?,?,?,?,sysdate)";
        Connection conn =DButil.getConnection();
        PreparedStatement ptmt= conn.prepareStatement(sql);
        ptmt.setString(1, u.getUname());
        ptmt.setString(2, u.getTruename());
        ptmt.setString(3, u.getPwd());
        ptmt.setString(4, u.getSex());
        ptmt.setString(5, u.getCernum());
        ptmt.setString(6, u.getMail()); 
        ptmt.setString(7, u.getPhone());
        ptmt.execute();
    }
    public void del(Integer id) throws SQLException {
    	String sql="delete from users where id=?";
    	Connection conn =DButil.getConnection();
        PreparedStatement ptmt= conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }
    public void update(Users u,int id) throws SQLException {
    	String sql="update users set uname=?,truename=?,pwd=?,sex=?,cernum=?,mail=?,phone=? where usersid=?";
        Connection conn =DButil.getConnection();
        PreparedStatement ptmt= conn.prepareStatement(sql);
        ptmt.setString(1, u.getUname());
        ptmt.setString(2, u.getTruename());
        ptmt.setString(3, u.getPwd());
        ptmt.setString(4, u.getSex());
        ptmt.setString(5, u.getCernum());
        ptmt.setString(6, u.getMail()); 
        ptmt.setString(7, u.getPhone());
        ptmt.setInt(8, id);
        ptmt.execute();
    }
	public List<Users> query() throws Exception {
		Connection conn= DButil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery("select *from users");
		
		List<Users> us=new ArrayList<Users>();
		Users u=null;
		while(rs.next()) {
			u=new Users();
			u.setUname(rs.getString("uname"));
		    u.setUsersId(rs.getInt("usersId"));
		    u.setSex(rs.getString("sex"));
		    u.setPhone(rs.getString("phone"));
			us.add(u);
		}
		return us;
	} 
	public Users queryLogin(String uname) throws Exception {
		Connection conn= DButil.getConnection();
		String sql="select *from users where uname=?";
		
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, uname);
		ResultSet rs=ptmt.executeQuery();
		Users u=new Users();
		while(rs.next()) {
			u.setUname(rs.getString("uname"));
		    u.setPwd(rs.getString("pwd"));
		    u.setUsersId(rs.getInt("usersId"));
		}
		
		return u;
	}
	public Users get(Integer id) throws SQLException {
		Users u=null;
		Connection conn= DButil.getConnection();
		String sql="select * from users "+" where  usersId=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs= ptmt.executeQuery();
		while(rs.next()) {
			u=new Users();
            u.setCernum(rs.getString("cernum"));
            u.setDate(rs.getDate("datetime"));
            u.setMail(rs.getString("mail"));
            u.setPhone(rs.getString("phone"));
            u.setPwd(rs.getString("pwd"));
            u.setSex(rs.getString("sex"));
            u.setTruename(rs.getString("truename"));
            u.setUname(rs.getString("uname"));
            u.setUsersId(rs.getInt("usersid"));
		}
		return u;
	}
	public Users get(String uname) throws SQLException {
		Users u=null;
		Connection conn= DButil.getConnection();
		String sql="select * from users "+" where uname=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, uname);
		ResultSet rs= ptmt.executeQuery();
		if(rs.next()) {
			u=new Users();
            u.setCernum(rs.getString("cernum"));
            u.setDate(rs.getDate("datetime"));
            u.setMail(rs.getString("mail"));
            u.setPhone(rs.getString("phone"));
            u.setPwd(rs.getString("pwd"));
            u.setSex(rs.getString("sex"));
            u.setTruename(rs.getString("truename"));
            u.setUname(rs.getString("uname"));
            u.setUsersId(rs.getInt("usersid"));
            return u;
		}
		else {
			return null;
		}
	}
}
