package com.ecart.order.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AttributeOverride(name="transactionDate",column=@Column(name="cc_txDate",nullable=false))
public class CreditCard extends BillingDetails {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ccID;
	private Long CCNumber;
	private Date expDate;
	private String cardHolderName;
	public CreditCard(long ccID, Long cCNumber, Date expDate, String cardHolderName) {
		this.ccID = ccID;
		CCNumber = cCNumber;
		this.expDate = expDate;
		this.cardHolderName = cardHolderName;
	}
	public CreditCard() {
	}
	public long getCcID() {
		return ccID;
	}
	public void setCcID(long ccID) {
		this.ccID = ccID;
	}
	public Long getCCNumber() {
		return CCNumber;
	}
	public void setCCNumber(Long cCNumber) {
		CCNumber = cCNumber;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	@Override
	public String toString() {
		return "CreditCard [ccID=" + ccID + ", CCNumber=" + CCNumber + ", expDate=" + expDate + ", cardHolderName="
				+ cardHolderName + "]";
	}
}
