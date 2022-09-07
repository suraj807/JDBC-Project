package com.jdbc;
import java.sql.*;
import java.util.Scanner;

public class demoonjdbc3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/anudipdeeptech";
		Scanner bs=new Scanner(System.in);
		String username="root";
		String password="root";
		int empid,empsalary;
		String empName,empDomain;
		System.out.println("----welcome to Employee Management----");
		System.out.print("Employee Id :");
		empid=bs.nextInt();
		System.out.print("Employee Name");
		empName=bs.next();
		System.out.print("Employee domain");
		empDomain=bs.next();
		System.out.println("Employee Salary");
		empsalary=bs.nextInt();
		
		
		
		String query="insert into deeptechemp values(?,?,?,?)";
		Connection con=DriverManager.getConnection(url,username,password);
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,empid);
		pst.setString(2, empName);
		pst.setString(3, empDomain);
		pst.setInt(4, empsalary);
		
		int count=pst.executeUpdate();
		System.out.println(count+" row/s affected");
		
		
		
		
		bs.close();
		con.close();

	}

}
