package com.graphql.tutorial.resolvers.bank;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import com.graphql.tutorial.domain.bank.BankAccount;
import com.graphql.tutorial.domain.bank.Client;

import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

	private final ExecutorService executorService = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount) {
		log.info("stop for debug");
		return CompletableFuture.supplyAsync(() -> {
			log.info("Retrieving client information for bank acccount id: {}", bankAccount.getId());
			return DataFetcherResult.<Client>newResult()
					.data(Client.builder().id(UUID.randomUUID())
							.firstName("Pavani")
							.lastName("Ganisetti").build())
					.build();
		}, executorService);

	}

}
