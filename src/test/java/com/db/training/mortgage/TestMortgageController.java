package com.db.training.mortgage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.db.training.mortgage.controller.MortgageController;
import com.db.training.mortgage.dto.UserRequestDto;
import com.db.training.mortgage.entity.Loan;
import com.db.training.mortgage.service.MortgageService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestMortgageController {
	@InjectMocks
	MortgageController mortgageController;
	@Mock
	MortgageService mortgageService;
	
	@Test
	public void testApplyMortgagesForValidInputs() {
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setDob(null);
		userRequestDto.setEmail("");
		userRequestDto.setGender("");
		userRequestDto.setName("");
		userRequestDto.setSalary(30000);
		userRequestDto.setSecondIncome(10000);
		userRequestDto.setOtherIncome(10000);
		userRequestDto.setPanNumber("");
		userRequestDto.setPhoneNumber("");
		userRequestDto.setPropertyAddress("");
		userRequestDto.setPropertyArea(1000);
		userRequestDto.setPropertyName("");
		userRequestDto.setPropertyPincode("");
		userRequestDto.setPropertyType("");
		
		List<Loan> list = new ArrayList<>();
		
		Mockito.when( mortgageService.applyMortgages(userRequestDto)).thenReturn(list);
		List<Loan> result = mortgageController.applyMortgages(userRequestDto);
		Assert.assertEquals(list, result);
		
	}
}
