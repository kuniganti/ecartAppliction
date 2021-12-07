package com.ecart.order.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AttributeOverride(name="transactionDate",column=@Column(name="ba_txDate",nullable=false))
public class BankAccount extends BillingDetails {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bankAccountID;
	private long accountNumber;
	private String branchName;
	private String ifscCode;
	public BankAccount(long accountNumber, String branchName, String ifscCode) {
		this.accountNumber = accountNumber;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
	}
	public BankAccount() {
	}
	public long getBankAccountID() {
		return bankAccountID;
	}
	public void setBankAccountID(long bankAccountID) {
		this.bankAccountID = bankAccountID;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "BankAccount [bankAccountID=" + bankAccountID + ", accountNumber=" + accountNumber + ", branchName="
				+ branchName + ", ifscCode=" + ifscCode + /*", getBillingDetailsID()=" + getBillingDetailsID()
				+*/ ", getTransactionDate()=" + getTransactionDate() + "]";
	}
	
}
