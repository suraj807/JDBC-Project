package com.jdbc;

import java.util.Scanner;

public class consumeemp {

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		
		int empid=110,empsalary=42000;
		String empName="Priyanshu",empDomain="Java";
		Scanner bs=new Scanner(System.in);
		System.out.println("---welcome to Employee Management----");
		System.out.println("Press 1 for add emp \n Press 2 for retrive emp");
		int op=bs.nextInt();
		empDAO dao=new empDAO();
		dao.connect();
		
		switch(op) {
		
		case 1 : {
			System.out.print("Employee Id :");
			empid=bs.nextInt();
			System.out.print("Employee Name");
			empName=bs.next();
			System.out.print("Employee domain");
			empDomain=bs.next();
			System.out.println("Employee Salary");
			empsalary=bs.nextInt();
		
			emp e1=new emp();
			e1.eId=empid;
			e1.eName=empName;
			e1.eDomain=empDomain;
			e1.eSalary=empsalary;
			dao.addEmp(e1);	
		}
		break;
		case 2 : {
			System.out.println("Enter eid for details");
			int eid=bs.nextInt();
			emp e2=dao.getEmp(eid);
			System.out.println(e2.eId+" is "+e2.eName+" working in "+e2.eDomain+" with "+e2.eSalary+" salary");
				
		}
		
		
		
		
	}


	}

}
