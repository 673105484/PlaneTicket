package com.ljn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljn.model.Flight;
import com.ljn.model.FlightCompany;
import com.ljn.model.Users;

public class Test {
	public static void main(String[] args) throws Exception {
         UsersDao ud=new UsersDao();
         FlightCompanyDao fcd=new FlightCompanyDao();
         //Users u=new Users();
         //增加  Users u =new Users("李四","李华","123456","男","50000067554432","21356","138765464");
     
           List <Users> lu=ud.query();
         for (int i = 0; i < lu.size(); i++) {
			System.out.println(lu.get(i).getUsersId()+lu.get(i).getUname());
		}
		
         /*修改 Users u1 =new Users("李四","李华","123456","女","50000067554432","21356","138765464");
         ud.update(u1);
         */
         //FlightCompany fc=new FlightCompany("航空1","重庆","141321431","34321@qq.com",1);
         //FlightCompany fc2=new FlightCompany("航空2","重庆","11241431","3234521@qq.com",1);
         //fcd.add(fc);
         //fcd.add(fc2);
        //u= ud.queryLogin("李四");
        //System.out.println(u.toString());
       /*  FlightDao d=new FlightDao();
         List<Flight> li= d.query();
         Flight f=new Flight();
         for(int i=1;i<li.size();i++) {
        	 System.out.println(li.get(i).toString());
         }*/
         FlightDao fd=new FlightDao();
         List<Flight> list= fd.query("重庆", "北京");
         for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	 
}