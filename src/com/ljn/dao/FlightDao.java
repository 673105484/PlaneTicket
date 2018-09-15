package com.ljn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ljn.db.DButil;
import com.ljn.model.Flight;
import com.ljn.model.FlightCompany;
import com.ljn.model.Users;

public class FlightDao {
	/*public void add(Flight f) throws SQLException {
		String sql = "insert into flight (cname,caddress,phone,cmail,fcstate ) "
				+ " values(?,?,?,?,?)";
		Connection conn = DButil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, f.getCname());
		ptmt.setString(2, f.getCaddress());
		ptmt.setString(3, f.getPhone());
		ptmt.setString(4, f.getCmail());
		ptmt.setInt(5, f.getFcstate());
		ptmt.execute();
	}*/
	public List<Flight> query() throws Exception {
		Connection conn = DButil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select *from flight");
		List<Flight> ft = new ArrayList<Flight>();
		Flight f=null;
		while (rs.next()) {
			f=new Flight();
			f.setCompanyId(rs.getInt("companyid"));
			f.setEndtime(rs.getDate("endtime"));
			f.setFend(rs.getString("fend"));
			f.setFlightId(rs.getString("flightid"));
			f.setFstart(rs.getString("fstart"));
			f.setHpiao(rs.getInt("hpiao"));
			f.setHprice(rs.getInt("hprice"));
			f.setJpiao(rs.getInt("jpiao"));
			f.setJprice(rs.getInt("jprice"));
			f.setStarttime(rs.getDate("starttime"));
			ft.add(f);
		}
		return ft;
	}
	public List<Flight> query(String fstart,String fend) throws Exception {
		Connection conn = DButil.getConnection();
		String sql="select * from flight where fstart=? and fend=? ";
		PreparedStatement ptmt= conn.prepareStatement(sql);
		ptmt.setString(1, fstart);
		ptmt.setString(2, fend);
		ResultSet rs = ptmt.executeQuery();
		List<Flight> ft = new ArrayList<Flight>();
		Flight f=null;
		while (rs.next()) {
			f=new Flight();
			f.setCompanyId(rs.getInt("companyid"));
			f.setEndtime(rs.getDate("endtime"));
			f.setFend(rs.getString("fend"));
			f.setFlightId(rs.getString("flightid"));
			f.setFstart(rs.getString("fstart"));
			f.setHpiao(rs.getInt("hpiao"));
			f.setHprice(rs.getInt("hprice"));
			f.setJpiao(rs.getInt("jpiao"));
			f.setJprice(rs.getInt("jprice"));
			f.setStarttime(rs.getDate("starttime"));
			ft.add(f);
		}
		return ft;
	}
	public Flight get(String fid ) throws SQLException {
		Connection conn = DButil.getConnection();
		Flight f=new Flight();
		String sql="select * from flight where flightId=? ";
		PreparedStatement ptmt= conn.prepareStatement(sql);
		ptmt.setString(1, fid);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			f.setJpiao(rs.getInt("jpiao"));
			f.setHpiao(rs.getInt("hpiao"));
		}
		return f;
		
	}
    public void update(Flight f,String fid) throws SQLException {
    	String sql="update flight set jpiao=?,hpiao=? where flightId=? ";
        Connection conn =DButil.getConnection();
        PreparedStatement ptmt= conn.prepareStatement(sql);
        ptmt.setInt(1, f.getJpiao());
        ptmt.setInt(2, f.getHpiao());
        ptmt.setString(3, fid);
        ptmt.execute();
    }
}
