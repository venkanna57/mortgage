package com.db.training.mortgage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.training.mortgage.dto.UserRequestDto;
import com.db.training.mortgage.entity.Loan;
import com.db.training.mortgage.exception.LoanNotFoundException;
import com.db.training.mortgage.exception.UserNotFoundException;
import com.db.training.mortgage.service.MortgageService;

/**
 *this class is for mortgage related functionality 
 * @author Venkanna G
 *
 */
@RestController
@RequestMapping("/applymortgage")
public class MortgageController {

private static Logger logger = LoggerFactory.getLogger(MortgageController.class);
	
	@Autowired
	MortgageService mortgageService;
	
	/**
	 * this method is for displaying list of loans once user submit his income details,etc.
	 * @param userRequestDto
	 * @return LoanDetails
	 * @exception LoanNotFoundException if user is not eligible for any loan
	 * @exception Exception if Server is not available
	 */
	@PostMapping("/applymortgage")
	public List<Loan> applyMortgages(@RequestBody UserRequestDto userRequestDto) {
		logger.info("In MortgageController applyMortgages api : " + userRequestDto.getPanNumber());
		return mortgageService.applyMortgages(userRequestDto);
	}
	
	
	/**
	 * this method is for selecting loan option
	 * @param userId
	 * @param loanId
	 * @return String
	 * @exception Exception Server not available
	 */
	@PostMapping("/submit")
	public ResponseEntity<String> selectLoan(@RequestParam Integer userId,@RequestParam Integer loanId) throws LoanNotFoundException,UserNotFoundException{
		logger.info("In MortgageController selectLoan api : " + userId+" "+loanId);
		String msg =  mortgageService.selectLoan(userId,loanId);
		if (msg != null)
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		else 
			return new ResponseEntity<>("Mortgage Loan Already Applied", HttpStatus.NOT_FOUND);
	}
}
