package br.edu.heitorpk.classes;

import java.io.Serializable;
import java.util.Calendar;

public class controle_de_caixa implements Serializable{

	private int id_caixa;
	private Calendar entrada;
	private float saldo;
	private Calendar saida;
	
	public controle_de_caixa() {
		super();
	}

	public controle_de_caixa(int id_caixa, Calendar entrada, float saldo,
			Calendar saida) {
		super();
		this.id_caixa = id_caixa;
		this.entrada = entrada;
		this.saldo = saldo;
		this.saida = saida;
	}

	public int getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(int id_caixa) {
		this.id_caixa = id_caixa;
	}

	public Calendar getEntrada() {
		return entrada;
	}

	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Calendar getSaida() {
		return saida;
	}

	public void setSaida(Calendar saida) {
		this.saida = saida;
	}
	
	
}
