package com.jdbc;
import java.sql.*;
public class demoonjdbc2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/anudipdeeptech";
		String username="root";
		String password="root";
		
		String query="insert into deeptechemp values(107,'Aktar','AWS',25000)";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		System.out.println(count+" row/s effected");

	}

}
