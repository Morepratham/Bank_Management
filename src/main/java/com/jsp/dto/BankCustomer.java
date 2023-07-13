package com.jsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cust_id;
	private String cust_name;
	private String cust_gender;
	private String cust_email;
	private String cust_password;
	private String cust_status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pan pan;
	//
	//@OneToMany
	//private List<Bank> banks;
	@OneToOne(cascade = CascadeType.ALL)
	private BankAccount bankAccount;
	//@ManyToMany
	//private List<BankManager> bankmanager;
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_gender() {
		return cust_gender;
	}
	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_password() {
		return cust_password;
	}
	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}
	public String getCust_status() {
		return cust_status;
	}
	public void setCust_status(String cust_status) {
		this.cust_status = cust_status;
	}
	public Pan getPan() {
		return pan;
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
}
