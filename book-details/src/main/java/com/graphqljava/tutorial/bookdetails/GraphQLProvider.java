package com.graphqljava.tutorial.bookdetails;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;

@Component
public class GraphQLProvider {
	private GraphQL graphQL;

	@Autowired
	private GraphQLDataFetchers graphQLDataFetchers;

	@PostConstruct
	public void init() throws IOException {
		URL url = Resources.getResource("schema.graphqls");
		String urlString = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = buildSchema(urlString);
		this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	private GraphQLSchema buildSchema(String urlString) {
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(urlString);
		RuntimeWiring runtimeWiring = buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}

	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("bookById",
						graphQLDataFetchers.getBookByIdDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Book").dataFetcher("author",
						graphQLDataFetchers.getAuthorDataFetcher()))
				.build();
	}

	@Bean
	public GraphQL graphQL() {
		return graphQL;
	}

}
