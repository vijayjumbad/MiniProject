package com.nt.bo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEE")
public class EmployeeBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMPNO")
	private int empNo;
	//@Column(name="ENAME")
	private String eName;
	private String addrs;
	private float salary;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeBO [empNo=" + empNo + ", eName=" + eName + ", addrs=" + addrs + ", salary=" + salary + "]";
	}
	
	
}
