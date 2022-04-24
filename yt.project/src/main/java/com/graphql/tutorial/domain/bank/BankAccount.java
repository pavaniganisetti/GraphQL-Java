package com.graphql.tutorial.domain.bank;



import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BankAccount {
	UUID id;
	Client client;
	Currency currency;
	ZonedDateTime createdAt;
	LocalDate createdOn;
}
