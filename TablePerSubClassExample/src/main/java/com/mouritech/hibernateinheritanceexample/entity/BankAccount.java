package com.mouritech.hibernateinheritanceexample.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "bank12")
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNo;
	private String accountName;
	private double balence;
	public BankAccount(int accountNo, String accountName, double balence) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balence = balence;
	}
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalence() {
		return balence;
	}
	public void setBalence(double balence) {
		this.balence = balence;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountName=" + accountName + ", balence=" + balence + "]";
	}
	
}
