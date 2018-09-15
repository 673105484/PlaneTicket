package com.ljn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ljn.db.DButil;
import com.ljn.model.FlightCompany;

public class FlightCompanyDao {
	public void add(FlightCompany f) throws SQLException {
		String sql = "insert into flightCompany (cname,caddress,phone,cmail,fcstate ) "
				+ " values(?,?,?,?,?)";
		Connection conn = DButil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, f.getCname());
		ptmt.setString(2, f.getCaddress());
		ptmt.setString(3, f.getPhone());
		ptmt.setString(4, f.getCmail());
		ptmt.setInt(5, f.getFcstate());
		ptmt.execute();
	}

	public void del(Integer id) throws SQLException {
		String sql = "delete from flightCompany where id=?";
		Connection conn = DButil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}

	public void update(FlightCompany f) throws SQLException {
		String sql = "update flightCompany set cname=?,caddress=?,phone=?,cmail=?,fcstate=? ";
		Connection conn = DButil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, f.getCname());
		ptmt.setString(2, f.getCaddress());
		ptmt.setString(3, f.getPhone());
		ptmt.setString(4, f.getCmail());
		ptmt.setInt(5, f.getFcstate());
		ptmt.execute();
	}

	public List<FlightCompany> query() throws Exception {
		Connection conn = DButil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select *from flightCompany");

		List<FlightCompany> fs = new ArrayList<FlightCompany>();
		FlightCompany f = null;
		while (rs.next()) {
			f = new FlightCompany();
			f.setCname(rs.getString("cname"));
			f.setCaddress(rs.getString("caddress"));
            f.setCmail(rs.getString("cmail"));
            f.setPhone(rs.getString("phone"));
			fs.add(f);
		}
		return fs;
	}

	public FlightCompany get(Integer id) throws SQLException {
		FlightCompany f = null;
		Connection conn = DButil.getConnection();
		String sql = "select * from flightCompany " + " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			f = new FlightCompany();
			f.setCaddress(rs.getString("caddress"));
			f.setCmail(rs.getString("cmail"));
			f.setCname(rs.getString("cname"));
			f.setFcstate(rs.getInt("fcstate"));
			f.setFlightCompanyId(rs.getInt("flightCompanyId"));
			f.setPhone(rs.getString("phone"));
		}
		return f;
	}
}
