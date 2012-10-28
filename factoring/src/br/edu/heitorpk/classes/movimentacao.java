package br.edu.heitorpk.classes;

import java.util.Calendar;

public class movimentacao {

	private int id_movimentacao;
	private float valor_movimentacao;
	private Calendar hora_movimentacao;
	private controle_de_caixa id_caixa;
	
	public movimentacao() {
		super();
	}

	public movimentacao(int id_movimentacao, float valor_movimentacao,
			Calendar hora_movimentacao, controle_de_caixa id_caixa) {
		super();
		this.id_movimentacao = id_movimentacao;
		this.valor_movimentacao = valor_movimentacao;
		this.hora_movimentacao = hora_movimentacao;
		this.id_caixa = id_caixa;
	}

	public int getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(int id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}

	public float getValor_movimentacao() {
		return valor_movimentacao;
	}

	public void setValor_movimentacao(float valor_movimentacao) {
		this.valor_movimentacao = valor_movimentacao;
	}

	public Calendar getHora_movimentacao() {
		return hora_movimentacao;
	}

	public void setHora_movimentacao(Calendar hora_movimentacao) {
		this.hora_movimentacao = hora_movimentacao;
	}

	public controle_de_caixa getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(controle_de_caixa id_caixa) {
		this.id_caixa = id_caixa;
	}
	
	
}
