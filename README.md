## Table of Contents

* [Introduction](#Introduction)
* [Summary](#summary)

## Introduction
This repository contains different ways of implementing graphql server in java.
	
## Summary

* [GraphQL-Server-Implementation](#Graphql-Server-Implementation)

## Graphql-Server-Implementation
The way is to use the default graphql-java implementation https://github.com/graphql-java/graphql-java. With this way we need to manually provide the graphql object
to the springboot, configured with the schema and data fetcher details. A static array of data is used to create a simple project(Book details). You can find a detailed
explaination here in this website https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/
	
## Setup
Simply import this project in the Springboot STS and you would be good to you. However you may not be able to run all the projects since data fetching apis wont be
available for you.
