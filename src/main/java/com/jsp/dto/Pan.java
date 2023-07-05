package com.jsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pan_id;
	private String pan_number;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankCustomer bankCustomer;
	
	public int getPan_id() {
		return pan_id;
	}
	public void setPan_id(int pan_id) {
		this.pan_id = pan_id;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public BankCustomer getBankCustomer() {
		return bankCustomer;
	}
	public void setBankCustomer(BankCustomer bankCustomer) {
		this.bankCustomer = bankCustomer;
	}
	
	
}
