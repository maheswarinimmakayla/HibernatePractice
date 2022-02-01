package com.mouritech.hibernateinheritanceexample;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.hibernateinheritanceexample.entity.SavingsAccount;
import com.mouritech.hibernateinheritanceexample.entity.BankAccount;
import com.mouritech.hibernateinheritanceexample.entity.CurrentAccount;
import com.mouritech.hibernateinheritanceexample.util.HibernateUtil;
public class TestClassPerInheritance {
	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			BankAccount bank = new BankAccount();
			bank.setAccountName("Rama");
            bank.setBalence(545.4);
            bank.deposite();
            bank.withdraw();
			
            
			CurrentAccount caccount = new CurrentAccount();
			bank.setAccountName("sitha");
			caccount.setBalence(545.4);
			caccount.setServiceCharge(10.4f);
			

			SavingsAccount saccount = new SavingsAccount();
			bank.setAccountName("Ravi");
			saccount.setBalence(545.4);
			saccount.setIntersetRate(34.4f);
			

			// save all the above employee objects in to database
			session.save(bank);
			session.save(caccount);
			session.save(saccount);
			// commit transaction
			transaction.commit();
		  } catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}
}
