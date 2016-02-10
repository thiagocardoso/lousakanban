package com.thiagocardoso.tcc.entities;

public enum Status {
	ABERTO("Aberto"), 
	DESENVOLVENDO("Desenvolvendo"), 
	RESOLVIDO("Resolvido"), 
	CANCELADO("Cancelado");
	
	private String description;

	Status(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}