package com.graphql.tutorial.resolvers.bank.query;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.graphql.tutorial.domain.bank.BankAccount;
import com.graphql.tutorial.domain.bank.Currency;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

	public BankAccount bankAccount(UUID id, DataFetchingEnvironment e) {

		var collect = e.getSelectionSet().getFields().stream().map(SelectedField::getName)
				.collect(Collectors.toUnmodifiableSet());

		log.info("Select Set: {}",collect);
		log.info("Retrieving bank accounts with id: {}", id);
		return BankAccount.builder().id(id).currency(Currency.USD).build();

	}
}
