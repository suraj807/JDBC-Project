package com.jdbc;
import java.sql.*;

public class demoonjdbc1 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//loading and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/anudipdeeptech";
		String username="root";
		String password="root";
		String query="select * from deeptechemp";
		//getting connection
	Connection con=DriverManager.getConnection(url,username,password);
	//creation of statement
	Statement st=con.createStatement();
	//execute statement
	ResultSet rs=st.executeQuery(query);
	//go to next element
	//process the result
	while(rs.next())
	{
	String emp="Employee name is "+rs.getString("ename")+" and his/her working in "+rs.getString("edomain")+" with package "+rs.getInt("esalary");
	System.out.println(emp);
	}
	//close connection
	con.close();
	}

}
