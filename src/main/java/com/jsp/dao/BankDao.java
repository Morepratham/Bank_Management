package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Bank;

public class BankDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pratham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Bank saveBankDetails(Bank bank) {
		if (bank != null) {
			entityTransaction.begin();
			entityManager.persist(bank);
			entityTransaction.commit();
		}
		return bank;
	}
//	get bank by id
	public Bank getBankById(int id) {
		Bank b = entityManager.find(Bank.class, id);
		return b;
	}

// get all bank
	public List<Bank> getAllBank() {
		String s = "SELECT b FROM Bank b";
		Query q = entityManager.createQuery(s);
		List<Bank> li = q.getResultList();
		return li;

	}

//Update Bank
	public Bank updateBank(int id, Bank bank) {
		entityTransaction.begin();
		Bank b = entityManager.find(Bank.class, id);
		if (bank.getBank_name() != null)
			b.setBank_name(bank.getBank_name());
		if (bank.getBank_city() != null)
			b.setBank_city(bank.getBank_city());
		if (bank.getBankAccounts() != null)
			b.setBankAccounts(null);
		if (bank.getBankmanagers() != null)
			b.setBankmanagers(bank.getBankmanagers());
		entityManager.persist(b);
		entityTransaction.commit();
		return b;
	}

// delete Bank By Id
	public boolean deleteBankById(int id) {
		entityTransaction.begin();
		Bank b = entityManager.find(Bank.class, id);
//		if (b.getBankAccount() != null)
//			entityManager.remove(b.getBankAccount());
//		if (!b.getManagers().isEmpty())
//			entityManager.remove(b.getManagers());
		entityManager.remove(b);
		entityTransaction.commit();
		return true;
	}
}
