package com.graphql.tutorial.exceptions;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

//@Component
public class CustomGraphQLExceptionHandler implements GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		return errors;
	}

}
