package com.ljn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ljn.db.DButil;
import com.ljn.model.Admin;

public class AdminDao {
     public Admin get(String uname) throws SQLException {
    	 Connection conn = DButil.getConnection();
 		String sql="select *from admin where uname=?";
 		PreparedStatement ptmt=conn.prepareStatement(sql);
 		ptmt.setString(1, uname);
 		ResultSet rs=ptmt.executeQuery();
 		Admin a=null;
 		if(rs.next()) {
 			a=new Admin();
 			a.setUname(rs.getString("uname"));
 			a.setPwd(rs.getString("pwd"));
 			a.setAdminId(rs.getInt("adminid"));
 		}
    	 return a;
     }
}
