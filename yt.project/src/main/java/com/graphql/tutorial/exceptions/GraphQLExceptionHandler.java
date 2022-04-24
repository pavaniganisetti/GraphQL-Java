package com.graphql.tutorial.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;

@Component
public class GraphQLExceptionHandler{
	
	@ExceptionHandler({GraphQLException.class,ConstraintViolationException.class})
	public ThrowableGraphQLError handler(Exception e) {
		return new ThrowableGraphQLError(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ThrowableGraphQLError handler(RuntimeException e) {
		return new ThrowableGraphQLError(e, "Internal Server error");
	}
}
