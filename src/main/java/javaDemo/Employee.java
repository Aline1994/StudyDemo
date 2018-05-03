package javaDemo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
	private String name;
	private double salary;
	private Date hireDate;
	
	public Employee(String name,Double salary) {
		this.name = name;
		this.salary = salary;
		hireDate = new Date();
	}
	
	public void setHireDate(int year,int month,int day) {
		Date newhireDay = new GregorianCalendar(year,month-1,day).getTime();
		hireDate.setTime(newhireDay.getTime());
	}
	public void raiseSalary(double byPercent) {
		double raise = salary*byPercent/100;
		salary+=raise;
	}
	//…Ó∏¥÷∆
	 public Employee clone() throws CloneNotSupportedException {
		 Employee cloned = (Employee) super.clone();
		 cloned.hireDate = (Date) hireDate.clone();
		return cloned;
		 
	 }
}
