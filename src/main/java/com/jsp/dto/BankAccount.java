package com.jsp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_id;
	private long account_number;
	private double account_balance;
	private String account_type;
	
	//@ManyToMany
	//private List<BankCustomer> bankcustomer1;
	@OneToOne(cascade = CascadeType.ALL)
	private BankCustomer bankcustomer;
	@ManyToOne
	private List<Bank> banks;
	
	@ManyToMany
	private List<BankManager> bankmanagers;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Bank bank;
	
	
	
	public BankCustomer getBankcustomer() {
		return bankcustomer;
	}
	public void setBankcustomer(BankCustomer bankcustomer) {
		this.bankcustomer = bankcustomer;
	}
	public List<Bank> getBanks() {
		return banks;
	}
	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}
	public List<BankManager> getBankmanagers() {
		return bankmanagers;
	}
	public void setBankmanagers(List<BankManager> bankmanagers) {
		this.bankmanagers = bankmanagers;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	
}
