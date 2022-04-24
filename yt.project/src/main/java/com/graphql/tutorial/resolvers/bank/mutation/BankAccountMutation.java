package com.graphql.tutorial.resolvers.bank.mutation;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.graphql.tutorial.domain.bank.BankAccount;
import com.graphql.tutorial.domain.bank.Currency;
import com.graphql.tutorial.domain.bank.input.CreateBankAcccountInput;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

	private final Clock clock;

	public BankAccount createBankAccount(@Valid CreateBankAcccountInput input, DataFetchingEnvironment e) {

		log.info("Creating bank account for {}", input);
		return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).createdAt(ZonedDateTime.now(clock))
				.createdOn(LocalDate.now(clock)).build();
	}
}
