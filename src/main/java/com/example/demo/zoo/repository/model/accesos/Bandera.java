package com.example.demo.zoo.repository.model.accesos;

public class Bandera {

	private boolean bandera;

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	@Override
	public String toString() {
		return "Bandera [bandera=" + bandera + "]";
	}
}