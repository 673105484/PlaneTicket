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
         //����  Users u =new Users("����","�","123456","��","50000067554432","21356","138765464");
     
           List <Users> lu=ud.query();
         for (int i = 0; i < lu.size(); i++) {
			System.out.println(lu.get(i).getUsersId()+lu.get(i).getUname());
		}
		
         /*�޸� Users u1 =new Users("����","�","123456","Ů","50000067554432","21356","138765464");
         ud.update(u1);
         */
         //FlightCompany fc=new FlightCompany("����1","����","141321431","34321@qq.com",1);
         //FlightCompany fc2=new FlightCompany("����2","����","11241431","3234521@qq.com",1);
         //fcd.add(fc);
         //fcd.add(fc2);
        //u= ud.queryLogin("����");
        //System.out.println(u.toString());
       /*  FlightDao d=new FlightDao();
         List<Flight> li= d.query();
         Flight f=new Flight();
         for(int i=1;i<li.size();i++) {
        	 System.out.println(li.get(i).toString());
         }*/
         FlightDao fd=new FlightDao();
         List<Flight> list= fd.query("����", "����");
         for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	 
}