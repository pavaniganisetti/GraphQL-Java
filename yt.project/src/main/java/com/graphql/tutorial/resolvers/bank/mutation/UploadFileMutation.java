package com.graphql.tutorial.resolvers.bank.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

	public UUID uploadFile(DataFetchingEnvironment environment) {
		log.info("Upload file");

		DefaultGraphQLServletContext context = environment.getContext();
		context.getFileParts()
				.forEach(part -> log.info("file name {} file size {}", part.getSubmittedFileName(), part.getSize()));

		return UUID.randomUUID();
	}

}
