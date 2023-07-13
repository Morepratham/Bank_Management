package com.jsp.service;

import java.util.List;

import com.jsp.dao.BankAccountDao;
import com.jsp.dto.BankAccount;

public class BankAccountService {
	BankAccountDao bankAccountDao = new BankAccountDao();

	public BankAccount saveBankAccountById(int person_id, BankAccount bankAccount) {

		return bankAccountDao.saveBankAccountById(person_id, bankAccount);

	}

	public BankAccount getAccountDetailsById(int person_id) {

		return bankAccountDao.getAccountDetailsById(person_id);

	}

	public List<BankAccount> getAllAccountDetails() {

		return bankAccountDao.getAllAccountDetails();
	}

	public boolean deleteBankAccountById(int account_id) {

		return bankAccountDao.deleteBankAccountById(account_id);
	}

	public BankAccount depositMoney(int account_id, int person_id, long depositAmmout) {

		return bankAccountDao.depositMoney(account_id, person_id, depositAmmout);
	}

	public BankAccount widthrawMoney(int account_id, int person_id, long withdrawlMoney) {

		return bankAccountDao.widthrawMoney(account_id, person_id, withdrawlMoney);
	}

	public BankAccount transferMoney(int senderAcc_id, int receiverAcc_id, long transferAmmount) {

		return bankAccountDao.transferMoney(senderAcc_id, receiverAcc_id, transferAmmount);
	}
}
