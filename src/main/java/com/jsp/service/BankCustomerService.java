package com.jsp.service;

import java.util.List;

import com.jsp.dao.BankCustomerDao;
import com.jsp.dto.BankCustomer;

public class BankCustomerService {
	BankCustomerDao bankCustomerDao = new BankCustomerDao();

	public BankCustomer savePersonDetails(BankCustomer bankCustomer) {
		if (bankCustomerDao != null) {
			return bankCustomerDao.savePersonDetails(bankCustomer);

		} else {
			return null;
		}

	}

	public BankCustomer getPersonById(int id) {
		if (id > 0) {
			return bankCustomerDao.getPersonById(id);
		} else {
			return null;
		}
	}

	public List<BankCustomer> getAllPerson() {
		return bankCustomerDao.getAllPerson();
	}

	public BankCustomer updatePersonById(int bankCustomer_id, BankCustomer bankCustomer) {
		if (bankCustomer != null) {
			return bankCustomerDao.updatePersonById(bankCustomer_id, bankCustomer);
		} else {
			return null;
		}
	}

	public boolean deletePersonById(int id) {
		if (id > 0) {
			return bankCustomerDao.deletePersonById(id);
		} else {
			return false;
		}
	}

	public boolean saveMultiplePerson(List<BankCustomer> bankCustomer) {
		if (!bankCustomer.isEmpty()) {
			return bankCustomerDao.saveMultiplePerson(bankCustomer);
		}else {
			return false;
		}
	}
}
