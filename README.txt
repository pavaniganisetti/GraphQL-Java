It seems there are multiple ways to integrate GraphQL with Java-Springboot

TYPE-1

	-It is from Spring Project
	-It uses the @QueryMapping, and @SchemaMapping annotations
	-It is the successor of Spring for GraphQL
	
TYPE-2
	
	-Is is a kickstart project maintained by a small(https://www.graphql-java-kickstart.com/)
	-It uses the Mutation and Query resolver clases
	-It uses the graphql-java-tools and graphql-springboot-starter

TYPE-3

	-It is the reference from graphql-java website
	-It makes use of graphql-java & graphql-java-springboot-starter-webmvc
	-Here we make use of runtime wiring,data fetchers etc
	-Book details project is developed using this
