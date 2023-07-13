package com.jsp.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankAccount;
import com.jsp.dto.BankCustomer;
import com.jsp.service.BankCustomerService;

public class BankAccountDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pratham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

// Save account 
	public BankAccount saveBankAccountDetails(BankAccount bankAccount) {
		entityTransaction.begin();
		entityManager.persist(bankAccount);
		entityTransaction.commit();
		return bankAccount;
	}

	BankCustomerService bankCustomerService = new BankCustomerService();
	Random r = new Random();

// open account by id
	public BankAccount saveBankAccountById(int person_id, BankAccount bankAccount) {
		BankCustomer p = bankCustomerService.getPersonById(person_id);
		BankAccount bank = p.getBankAccount();
		if (p != null && bank == null && p.getCust_status().equalsIgnoreCase("approved")) {

			entityTransaction.begin();
			BankAccount ba = new BankAccount();

			long account_no = r.nextLong(10000000000l);
			ba.setAccount_balance(bankAccount.getAccount_balance());
			ba.setAccount_number(account_no);
			ba.setBankcustomer(p);
			ba.setAccount_type(bankAccount.getAccount_type());
			p.setBankAccount(ba);
			ba.setBank(bankAccount.getBank());
			entityManager.merge(ba);
			entityTransaction.commit();
			return ba;
		} else {
			return null;
		}

	}

// get account details by id
	public BankAccount getAccountDetailsById(int person_id) {
		BankCustomer p1 = bankCustomerService.getPersonById(person_id);
		if (p1.getCust_status().equalsIgnoreCase("approved") && p1.getBankAccount() != null) {
			BankAccount ba = p1.getBankAccount();

			return ba;
		} else {
			return null;
		}
	}

	// Get All Account Details
	public List<BankAccount> getAllAccountDetails() {
		String s = "SELECT b FROM BankAccount b";
		Query q = entityManager.createQuery(s);
		List<BankAccount> li = q.getResultList();
		return li;
	}

	// delete Account By Id
	public boolean deleteBankAccountById(int acc_id) {
		entityTransaction.begin();
		BankAccount ba = entityManager.find(BankAccount.class, acc_id);
		if (ba != null) {
			entityManager.remove(ba);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	// deposit money

	public BankAccount depositMoney(int acc_id, int p_id, long depositAmmout) {
		if (acc_id > 0 && p_id > 0) {
			entityTransaction.begin();
			BankCustomer p = bankCustomerService.getPersonById(p_id);
			BankAccount ba = entityManager.find(BankAccount.class, acc_id);
			if (p != null && ba != null) {
				ba.setAccount_balance(ba.getAccount_balance() + depositAmmout);
				entityManager.persist(ba);
				entityTransaction.commit();

				return ba;
			} else {
				entityTransaction.commit();
				return null;
			}
		} else {
			return null;
		}
	}

	// widthraw money
	public BankAccount widthrawMoney(int acc_id, int p_id, long withdrawlMoney) {

		if (acc_id > 0 && p_id > 0) {
			BankAccount ba = entityManager.find(BankAccount.class, acc_id);
			BankCustomer p = bankCustomerService.getPersonById(p_id);
			if (ba.getAccount_balance() >= withdrawlMoney) {
				entityTransaction.begin();
				ba.setAccount_balance(ba.getAccount_balance() - withdrawlMoney);
				entityManager.merge(ba);
				entityTransaction.commit();
				return ba;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public BankAccount transferMoney(int senderAcc_id, int receiverAcc_id, long transferAmmount) {
		if (senderAcc_id > 0 && receiverAcc_id > 0) {
			BankAccount senderAccount = entityManager.find(BankAccount.class, senderAcc_id);
			BankAccount receiverAccount = entityManager.find(BankAccount.class, receiverAcc_id);
			if (senderAccount != null && receiverAccount != null && senderAccount.getAccount_balance() >= transferAmmount) {
				entityTransaction.begin();
				senderAccount.setAccount_balance(senderAccount.getAccount_balance() - transferAmmount);
				receiverAccount.setAccount_balance(receiverAccount.getAccount_balance() + transferAmmount);
				entityManager.persist(senderAccount);
				entityManager.persist(receiverAccount);
				entityTransaction.commit();
				return senderAccount;
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

}
