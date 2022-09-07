package com.jdbc;
import java.sql.*;

public class empDAO {
	Connection con=null;
	public void connect() throws Exception{
		//connection for the database
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","root");
	}
	
	public void addEmp(emp e1)throws Exception {
		String query="insert into deeptechemp values(?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,e1.eId);
		pst.setString(2,e1.eName);
		pst.setString(3,e1.eDomain);
		pst.setInt(4, e1.eSalary);
		
		int count=pst.executeUpdate();
		System.out.println(count+"rows affected");
	}
	
	public emp getEmp(int eid)throws Exception {
		
		emp e=new emp();
		e.eId=eid;
		String query="select * from deeptechemp where eid="+eid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		e.eName=rs.getString(2);
		e.eDomain=rs.getString(3);
		e.eSalary=rs.getInt(4);
		return e;
	}
}
