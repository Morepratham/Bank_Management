package com.jsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class BankManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manager_id;
	private String manager_name;
	private String manager_email;
	
	@ManyToMany
//	private List<BankCustomer> bankCustomer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Bank bank;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn
//	private List<BankCustomer> bankCustomer;
	
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
