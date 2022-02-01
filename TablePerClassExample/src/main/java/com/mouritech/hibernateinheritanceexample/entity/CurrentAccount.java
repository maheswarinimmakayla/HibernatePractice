package com.mouritech.hibernateinheritanceexample.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "currentaccount1")
@AttributeOverrides({
	@AttributeOverride(name = "bid" ,column = @Column(name= "sid")),
	@AttributeOverride(name = "bname" ,column = @Column(name= "sname")),
})
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


