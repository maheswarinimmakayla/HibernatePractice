package com.mouritech.hibernateinheritanceexample.entity;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "savings12")
@PrimaryKeyJoinColumn(name = "sid")
public class SavingsAccount extends BankAccount {
		@Column(name = "bank_intersetRate")
		private float intersetRate;
		
		public SavingsAccount() {
			
		}
		public SavingsAccount( float intersetRate) {
			super();
			this.intersetRate = intersetRate;
		}
		

		public float getIntersetRate() {
			return intersetRate;
		}

		public void setIntersetRate(float intersetRate) {
			this.intersetRate = intersetRate;
		}
		

		
}
