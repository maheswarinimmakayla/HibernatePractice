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
		BankAccount bank = null;
		Session session = null;
		try {
	      session = HibernateUtil.getSessionFactory().openSession(); 

			// start the transaction
			transaction = session.beginTransaction();

			bank = new BankAccount();
			bank.setAccountName("Rama");
			bank.setBalence(545.4);
			
			CurrentAccount cbank = new CurrentAccount();
			cbank.setAccountName("Krishna");
			cbank.setBalence(10);
			cbank.setServiceCharge(45.5f);

			
			
			SavingsAccount saccount = new SavingsAccount();
			saccount.setAccountName("Ravi");
			saccount.setBalence(545.4);
			saccount.setIntersetRate(34.4f);

			// save all the above employee objects in to database
			session.persist(bank);
			session.saveOrUpdate(cbank);
			session.merge(saccount);
			// commit transaction
			transaction.commit();
		  } catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}finally {
			session.detach(bank);
			session.clear();
			session.close();
			session.evict(bank);
		}
	}

}
