package com.ljn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ljn.db.DButil;
import com.ljn.model.BookTicket;
import com.ljn.model.Flight;

public class BookTicketDao {
      BookTicket b= new BookTicket();
      public void add(BookTicket b) throws SQLException {
  		String sql = "insert into bookticket (hyid,uname,cernum,fid,phone,zwnumber,jptype,booktime ) "
				+ " values(?,?,?,?,?,?,?,sysdate)";
		Connection conn = DButil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, b.getHyid());
		ptmt.setString(2,b.getUname() );
		ptmt.setString(3,b.getCernum());
		ptmt.setString(4, b.getFid());
		ptmt.setString(5, b.getPhone());
		ptmt.setString(6, b.getZwNumber());
		ptmt.setInt(7, b.getJptype());
		ptmt.execute();
      }
      public void del(String bookTicketId) throws SQLException {
    		String sql = "delete from bookticket where bookTicketId=?";
    		Connection conn = DButil.getConnection();
    		PreparedStatement ptmt = conn.prepareStatement(sql);
    		ptmt.setString(1, bookTicketId);
    		ptmt.execute();
      }
  	public List<BookTicket> query(Integer id) throws Exception {
		Connection conn = DButil.getConnection();
		String sql="select *from bookticket where hyid=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		List<BookTicket> bt = new ArrayList<BookTicket>();
		BookTicket b=null;
		while (rs.next()) {
			b=new BookTicket();
            b.setBookTicketId(rs.getInt("bookticketid"));
            b.setBooktime(rs.getDate("booktime"));
            b.setCernum(rs.getString("cernum"));
            b.setFid(rs.getString("fid"));
            b.setHyid(rs.getInt("hyid"));
            b.setJptype(rs.getInt("jptype"));
            b.setPhone(rs.getString("phone"));
            b.setUname(rs.getString("uname"));
			bt.add(b);
		}
		return bt;
	}
}
