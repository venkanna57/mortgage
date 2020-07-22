package com.app.controller;

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

import com.app.dto.UserRequestDto;
import com.app.entity.Loan;
import com.app.service.MortgageService;

@RestController
@RequestMapping("/mortgages")
public class MortgageController {
	
	private static Logger logger = LoggerFactory.getLogger(MortgageController.class);
	
	@Autowired
	MortgageService mortgageService;
	
	@PostMapping("/applymortgage")
	public List<Loan> applyMortgages(@RequestBody UserRequestDto userRequestDto) {
		logger.info("In MortgageController applyMortgages api : " + userRequestDto.getPanNumber());
		return mortgageService.applyMortgages(userRequestDto);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<String> selectLoan(@RequestParam Integer userId,@RequestParam Integer loanId) {
		logger.info("In MortgageController selectLoan api : " + userId+" "+loanId);
		String msg =  mortgageService.selectLoan(userId,loanId);
		if (msg != null)
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		else 
			return new ResponseEntity<>("Mortgage Loan Already Applied", HttpStatus.NOT_FOUND);
	}

}
