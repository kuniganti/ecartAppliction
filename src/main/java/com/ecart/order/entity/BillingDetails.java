package com.ecart.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class BillingDetails {
	//private long billingDetailsID;
	@Column(name="txDate")
	private Date transactionDate;

	public BillingDetails(long billingDetailsID, Date transactionDate) {
		//this.billingDetailsID = billingDetailsID;
		this.transactionDate = transactionDate;
	}

	public BillingDetails() {
	}

	/*public long getBillingDetailsID() {
		return billingDetailsID;
	}

	public void setBillingDetailsID(long billingDetailsID) {
		this.billingDetailsID = billingDetailsID;
	}*/

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return /*"BillingDetails [billingDetailsID=" + billingDetailsID + */", transactionDate=" + transactionDate + "]";
	}
	
	
}
