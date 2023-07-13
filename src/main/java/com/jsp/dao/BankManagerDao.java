package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankManager;

public class BankManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Pratham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
// save manager
	public BankManager saveManager(BankManager manager) {
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}

//	get by id
	public BankManager getManagerById(int id) {
		BankManager m1 = entityManager.find(BankManager.class, id);
		return m1;
	}
	
//get all manager
	public List<BankManager> getAllManagers() {
		String s = "SELECT b FROM Manager b";
		Query q = entityManager.createQuery(s);
		List<BankManager> li = q.getResultList();
		return li;
	}
	
// Update manager
	public BankManager updateManager(int manager_id, BankManager manager) {

		BankManager manager2 = getManagerById(manager_id);
		if (manager2 != null) {
			entityTransaction.begin();
			if (manager.getManager_name() != null)
				manager.setManager_name(manager.getManager_name());
			if (manager.getBank() != null)
				manager.setBank(manager2.getBank());
			if (manager.getManager_email() != null)
				manager.setManager_email(manager.getManager_email());
			entityManager.persist(manager2);
			entityTransaction.commit();
			return manager2;
		} else {
			return null;
		}
	}

// delete manager By Id
	public boolean deleteManagerById(int id) {
		entityTransaction.begin();
		BankManager bm = getManagerById(id);
		if (bm != null) {
			entityManager.remove(bm);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

// save multiple manager
	public boolean saveMultipleManager(List<BankManager> managers) {
		entityTransaction.begin();

		for (BankManager bm : managers) {
			entityManager.persist(bm);
		}
		entityTransaction.commit();
		return true;
	}
}
