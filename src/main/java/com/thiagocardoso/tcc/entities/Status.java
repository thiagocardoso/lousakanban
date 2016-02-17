package com.thiagocardoso.tcc.entities;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Status {
	ABERTO("Aberto"), 
	DESENVOLVENDO("Desenvolvendo"), 
	RESOLVIDO("Resolvido"), 
	CANCELADO("Cancelado");

	private static final Map<String, Status> MAP = Maps.newHashMap();
	
	static {
		for (Status status : Status.values()) {
			MAP.put(status.description.toLowerCase(), status);
		}
	}

	private String description;

	Status(String description) {
		this.description = description;
	}
	
	public static Status fromDescription(String description) {
		return MAP.get(description);
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}