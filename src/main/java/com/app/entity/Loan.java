package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	
	private double loanAmount;
	
	private double interestRate;
	
	private Integer tenurePeriod;
	
	private double loanEMI;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getTenurePeriod() {
		return tenurePeriod;
	}

	public void setTenurePeriod(Integer tenurePeriod) {
		this.tenurePeriod = tenurePeriod;
	}

	public double getLoanEMI() {
		return loanEMI;
	}

	public void setLoanEMI(double loanEMI) {
		this.loanEMI = loanEMI;
	}
	
	

}
