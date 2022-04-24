package com.graphql.tutorial.resolvers.bank;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import com.graphql.tutorial.domain.bank.Asset;
import com.graphql.tutorial.domain.bank.BankAccount;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {

	private final ExecutorService executorService = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
		log.info("Stop for debug");
		return CompletableFuture.supplyAsync(() -> {
			log.info("retrieving assets for bank account id: {}", bankAccount.getId());
			return List.of();
		}, executorService);
	}
}
