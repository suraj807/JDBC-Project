package Bankproject;
import java.sql.*;

public class bankingdao {
Connection con=null;
	
	public void connect()throws Exception {
		//getting connection with DB
		Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","root");	
		
	}
	
	//register account
	public int registerCustomer(bankingcustomer b1)throws Exception {
		
		
		String username=b1.cname;
		String quer2= "select * from banking where cname='"+username+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(quer2);
		
		if(rs.next()) {
			
			return -1;
			
		}
		else {
			String query="insert into banking(cname,cpassword,cphone,caccbal) values(?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,b1.cname);
			pst.setString(2, b1.cpassword);
			pst.setString(3, b1.cphone);
			pst.setInt(4, b1.caccbal);
			int count=pst.executeUpdate();
			
			return count;
				
		}
		
	}
	
	public int login(String username, String pwd)throws Exception{
		//feteching the account details by username
		String query="select * from banking where cname= '"+username+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		if(rs.next()) {
		//fetching the password from db
			String cpwd=rs.getString(3);
			//matching the db password with enterd password
			if(cpwd.equals(pwd)) {
			int eid=rs.getInt(1);
			//if login success we can return cid
			return eid;
			}
			else {
			return 0;
				}
			}
			else {
			return -1;
			}
	}
	
	
	public int withdraw(int cid,int amount)throws Exception {
		//getting account details based on cid
		String query="select * from banking where cid="+cid;	
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		//fetching account balance
		int accbal=rs.getInt(5);
		//if account balance is greater than withdraw amount we can allow to withdraw
		if(accbal>amount) {
			accbal-=amount;
			String query2="update banking set caccbal="+accbal+" where cid="+cid;
			//updating the accbalance after withdraw
			Statement st2=con.createStatement();
			int res=st2.executeUpdate(query2);
			return accbal;
				}	
		else {
			return -1;
			}
		}
	
	
	public int deposit(int cid, int amount)throws Exception{
		//depositing
		String query="select * from banking where cid="+cid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next())
		{
		int accbal=rs.getInt(5);
		//adding amount to account balance
		accbal+=amount;
		//update account balance
		String query2="update banking set caccbal="+accbal+" where cid="+cid;
		PreparedStatement pst=con.prepareStatement(query2);
		pst.executeUpdate();
		return accbal;
		}
		else {
			return -1;
		}
	}
	
	public int checkBalance(int cid)throws Exception{
		//checking account balance
		String query="select * from banking where cid="+cid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		int accbal=rs.getInt(5);
		return accbal;
		
	}
	
	public int pinChange(int cid, String oldpin,String newPin)throws Exception{
		//getting details of the user
		String query="select * from banking where cid="+cid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String pwd=rs.getString(3);
		//matching present password to update new password
		if(pwd.equals(oldpin)) {
			String query2="update banking set cpassword="+newPin+" where cid="+cid;
			PreparedStatement pst=con.prepareStatement(query2);
			int count=pst.executeUpdate();
			return count;
		}
		else {
			return -1;
		}
		
	}
	

}
