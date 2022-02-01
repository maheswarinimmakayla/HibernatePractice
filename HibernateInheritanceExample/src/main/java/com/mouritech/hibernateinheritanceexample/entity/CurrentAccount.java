package com.mouritech.hibernateinheritanceexample.entity;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cuurentAccount")
public class CurrentAccount extends BankAccount {
	@Column(name="emp_serviceCharge")
	private float serviceCharge;

	public CurrentAccount() {
		
	}
	
	public CurrentAccount(float serviceCharge) {
		super();
		this.serviceCharge = serviceCharge;
	}

	public float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
}
