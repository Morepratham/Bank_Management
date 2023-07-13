package com.jsp.service;

import java.util.List;

import com.jsp.dao.BankDao;
import com.jsp.dto.Bank;

public class BankService {
	BankDao bankDao = new BankDao();

	public Bank saveBankDetails(Bank bank) {
		return bankDao.saveBankDetails(bank);

	}

	public Bank getBankByid(int id) {
		if (id > 0) {
			return bankDao.getBankById(id);
		} else {
			return null;
		}

	}

	public List<Bank> getAllBanks() {
		return bankDao.getAllBank();
	}

	public Bank getBankById(int id) {
		if (id > 0) {
			return bankDao.getBankById(id);
		} else {
			return null;
		}
	}

	public Bank updateBank(int id, Bank bank) {
		if (bank != null) {
			return bankDao.updateBank(id, bank);
		} else {
			return null;
		}
	}

	public boolean deleteBankById(int id) {
		if (id > 0) {
			return bankDao.deleteBankById(id);
		} else {
			return false;
		}
	}
}
