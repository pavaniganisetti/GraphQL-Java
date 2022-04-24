package com.graphql.tutorial.domain.bank;

import java.util.UUID;

import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class Asset {
	UUID id;
}
