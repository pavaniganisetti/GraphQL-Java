package com.graphql.tutorial.listener;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.stereotype.Component;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@RequiredArgsConstructor
public class LogListener implements GraphQLServletListener {

	private final Clock clock;

	@Override
	public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
		var startTime = Instant.now();
		log.info("Received a new graphql request");
		
		return new RequestCallback() {
			
			@Override
			public void onFinally(HttpServletRequest request, HttpServletResponse response) {
				log.info("Request Completed. Time taken {}", Duration.between(startTime, Instant.now(clock)));
			}
		};
	}
}
