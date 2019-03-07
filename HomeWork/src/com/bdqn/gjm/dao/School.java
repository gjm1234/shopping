package com.bdqn.gjm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class School {
List<Student> list = new ArrayList<>();
	
	public List<Student> seek(){
		try {
			//创建数据库连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取连接
			String url = "jdbc:mysql://localhost:3306/school";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			//3.创建一个statement
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			
			while(rs.next()){
				Student st = new Student();
				st.setStuid(rs.getInt("stu_no"));
				st.setStuame(rs.getString("stu_name"));
				st.setStusex(rs.getString("stu_sex"));
				st.setEmail(rs.getString("stu_email"));
				list.add(st);
			}
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int stuNo){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/school";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("DELETE FROM student WHERE stu_no="+stuNo);
			return i;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
