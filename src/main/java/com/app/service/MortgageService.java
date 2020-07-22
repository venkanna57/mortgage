package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.UserRequestDto;
import com.app.entity.Loan;
import com.app.entity.LoanDetail;
import com.app.entity.Property;
import com.app.entity.PropertyValue;
import com.app.entity.User;
import com.app.repository.LoanDetailRepository;
import com.app.repository.LoanRepository;
import com.app.repository.PropertyRepository;
import com.app.repository.PropertyValueRepository;
import com.app.repository.UserRepository;


@Service
public class MortgageService {
	private static Logger logger = LoggerFactory.getLogger(MortgageService.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PropertyRepository propertyRepository;
	@Autowired
	PropertyValueRepository propertyValueRepository;
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	LoanDetailRepository loanDetailRepository;
	
	public List<Loan> applyMortgages(@RequestBody UserRequestDto userRequestDto) {
		logger.info("In MortgageService applyMortgages api : " + userRequestDto.getPanNumber());
		User user = new User();
		Property property = new Property();
		BeanUtils.copyProperties(userRequestDto, user);
		userRepository.save(user);
		property.setUserId(user.getUserId());
		BeanUtils.copyProperties(userRequestDto, property);
		propertyRepository.save(property);
		
		double baseAmount = calculateOffer(user.getSalary(), user.getSecondIncome(), user.getOtherIncome());
		
		double area = property.getPropertyArea();
		String propertyPincode = property.getPropertyPincode();
		
		PropertyValue propertyValuereturned = propertyValueRepository.findByPincode(propertyPincode);
		double squareFeet = propertyValuereturned.getSquareFeetValue();
		double propertyCost = propertyValue(area,squareFeet);
		
		List<Loan> loanList = loanRepository.getAllLoanAmountBasedOnPropertyCost(propertyCost);
		List<Loan> loanList2 = loanRepository.getAllLoanAmountBasedOnBaseAmount(baseAmount);
		
		List<Loan> arraylist = new ArrayList<>();
		
		for(Loan loan:loanList2) {
			Integer loanId = loan.getLoanId();
			for(Loan loan2:loanList) {
					if(loan2.getLoanId().equals(loanId))
					arraylist.add(loan2);
			}
		}
		return arraylist;
	}
	
	
	private double calculateOffer(double salary,double secondIncome,double otherIncome) {
		return (0.4)*(salary+secondIncome+otherIncome);
	}
	
	private double propertyValue(double area,double  squareFeetValue) {
		return (0.8)*(area*squareFeetValue);
	}


	public String selectLoan(Integer userId, Integer loanId) {
		logger.info("In MortgageService selectLoan api : " + userId+" "+loanId);
		int count = 0;
		List<LoanDetail> loanDetails = loanDetailRepository.findByUserId(userId);
		
		for(LoanDetail loanDetail:loanDetails) {
			if(loanId == loanDetail.getLoanId())
				count++;
		}
		
		if(count==0) {
		LoanDetail loanDetail = new LoanDetail();
		loanDetail.setUserId(userId);
		loanDetail.setLoanId(loanId);
		loanDetailRepository.save(loanDetail);
		return "Mortgage Loan Applied SuccessFully";
		}else
			return null;
		
	}

}
