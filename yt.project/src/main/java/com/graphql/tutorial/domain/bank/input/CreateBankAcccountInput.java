package com.graphql.tutorial.domain.bank.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateBankAcccountInput {
	
	@NotBlank
	String firstName;
	int age;
}
