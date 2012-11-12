package br.edu.heitorpk.classes;

import java.io.Serializable;
import java.util.Calendar;

public class cheques implements Serializable{

	private int id_cheque;
	private String titular;
	private int banco;
	private int agencia;
	private int numero_conta;
	private int numero;
	private int cpf_cnpj;
	private int telefone;
	private float valor;
	private Calendar recebimento;
	private Calendar vencimento;
	private pessoa id_cliente;
	private tipo_cheque id_tipo;
	private movimentacao id_movimentacao;
	
	public cheques() {
		super();
	}

	public cheques(int id_cheque, String titular, int banco, int agencia,
			int numero_conta, int numero, int cpnf_cnpj, int telefone,
			float valor, Calendar recebimento, Calendar vencimento,
			pessoa id_cliente, tipo_cheque id_tipo, movimentacao id_movimentacao) {
		super();
		this.id_cheque = id_cheque;
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero_conta = numero_conta;
		this.numero = numero;
		this.cpf_cnpj = cpnf_cnpj;
		this.telefone = telefone;
		this.valor = valor;
		this.recebimento = recebimento;
		this.vencimento = vencimento;
		this.id_cliente = id_cliente;
		this.id_tipo = id_tipo;
		this.id_movimentacao = id_movimentacao;
	}

	public int getId_cheque() {
		return id_cheque;
	}

	public void setId_cheque(int id_cheque) {
		this.id_cheque = id_cheque;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(int numero_conta) {
		this.numero_conta = numero_conta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Calendar getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Calendar recebimento) {
		this.recebimento = recebimento;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public pessoa getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(pessoa id_cliente) {
		this.id_cliente = id_cliente;
	}

	public tipo_cheque getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(tipo_cheque id_tipo) {
		this.id_tipo = id_tipo;
	}

	public movimentacao getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(movimentacao id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}
	
	
}
