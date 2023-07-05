package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankCustomer;

public class BankCustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pratham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//	save person 
	public BankCustomer savePersonDetails(BankCustomer bankCustomer) {
		if (bankCustomer.getBankAccount() == null) {
			bankCustomer.setCust_status("unapproved");
			entityTransaction.begin();
			entityManager.persist(bankCustomer);
			entityTransaction.commit();
			return bankCustomer;
		} else {
			return null;
		}

	}

	public BankCustomer getPersonById(int id) {
		BankCustomer person = entityManager.find(BankCustomer.class, id);
		return person;

	}

//	get all person
	public List<BankCustomer> getAllPerson() {
		String s = "SELECT p FROM Person p";
		Query q = entityManager.createQuery(s);
		List<BankCustomer> li = q.getResultList();
		return li;
	}

// update person
	public BankCustomer updatePersonById(int person_id, BankCustomer person) {
		BankCustomer p1 = getPersonById(person_id);
		if (p1 != null) {
			entityTransaction.begin();
			if (person.getCust_email() != null) {
				p1.setCust_email(person.getCust_email());
			}
			if (person.getCust_gender() != null) {
				p1.setCust_gender(person.getCust_gender());
			}
			if (person.getCust_name() != null) {
				p1.setCust_name(person.getCust_name());
			}
			if (person.getCust_status() != null) {
				p1.setCust_status(p1.getCust_status());
			}
			entityManager.persist(p1);
			entityTransaction.commit();
			return p1;

		} else {
			return null;
		}
	}

	// delete Person By Id
	public boolean deletePersonById(int id) {
		entityTransaction.begin();
		BankCustomer p = getPersonById(id);
		if (p != null) {
			entityManager.remove(p);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	// save multiple person
	public boolean saveMultiplePerson(List<BankCustomer> bankCustomer) {
		entityTransaction.begin();

		for (BankCustomer p : bankCustomer) {
			p.setCust_status("UnApproved");
			entityManager.persist(p);
		}
		entityTransaction.commit();
		return true;
	}
}
