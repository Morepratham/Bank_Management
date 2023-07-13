package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.BankManagerDao;
import com.jsp.dto.BankCustomer;
import com.jsp.dto.BankManager;

public class BankManagerService {
	BankManagerDao managerDao = new BankManagerDao();
	BankCustomerService bankCustomerService = new BankCustomerService();
	public List<BankCustomer> viewAllPerson;

	public List<BankCustomer> viewAllPerson() {
		return bankCustomerService.getAllPerson();
	}

	public BankManager saveManager(BankManager manager) {
		if (manager != null) {
			return managerDao.saveManager(manager);
		} else {
			return null;
		}

	}

	public BankManager updateManager(int manager_id, BankManager manager) {
		if (manager_id > 0 && manager != null) {
			return managerDao.updateManager(manager_id, manager);

		} else {
			return null;

		}
	}

	public List<BankManager> getAllManagers() {
		return managerDao.getAllManagers();

	}

	public boolean deleteManagerById(int id) {
		if (id > 0) {
			return managerDao.deleteManagerById(id);
		} else {
			return false;
		}
	}

	public boolean saveMultipleManager(List<BankManager> managers) {
		if (!managers.isEmpty()) {
			return managerDao.saveMultipleManager(managers);
		} else {
			return false;
		}
	}

	public BankManager getManagerById(int id) {
		if (id > 0) {
			return managerDao.getManagerById(id);
		} else {
			return null;
		}
	}

	public BankManager approvePersonById(int person_id, int manager_id) {

		if (person_id > 0 && manager_id > 0) {
			BankManager bm = getManagerById(manager_id);
			BankCustomer p = bankCustomerService.getPersonById(person_id);
			if (person_id > 0 && bm != null && p.getPan() != null && p.getCust_status().equalsIgnoreCase("UnApproved")) {
				p.setCust_status("Approved");
				bankCustomerService.updatePersonById(person_id, p);
				return bm;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	public List<BankCustomer> viewAllUnApprovedPerson() {
		List<BankCustomer> unApprovedPersons = new ArrayList<>();
		List<BankCustomer> persons = bankCustomerService.getAllPerson();

		if (!persons.isEmpty()) {
			for (BankCustomer p : persons) {
				if (p.getCust_status().equalsIgnoreCase("UnApproved")) {
					unApprovedPersons.add(p);
				}
			}
		} else {
			return null;
		}
		return unApprovedPersons;
	}

	public List<BankCustomer> viewAllApprovedPerson() {
		List<BankCustomer> approvedPersons = new ArrayList<>();
		List<BankCustomer> persons = bankCustomerService.getAllPerson();

		if (!persons.isEmpty()) {
			for (BankCustomer p : persons) {
				if (p.getCust_status().equalsIgnoreCase("Approved")) {
					approvedPersons.add(p);
				}
			}
		} else {
			return null;
		}
		return approvedPersons;
	}
	public BankManager unApprovePersonById(int person_id, int manager_id) {

		if (person_id > 0 && manager_id > 0) {
			BankManager bm = getManagerById(manager_id);
			BankCustomer p = bankCustomerService.getPersonById(person_id);
			if (person_id > 0 && bm != null && p.getPan() != null && p.getCust_status().equalsIgnoreCase("UnApproved")) {
				p.setCust_status("UnApproved");
				bankCustomerService.updatePersonById(person_id, p);
				return bm;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}
}
