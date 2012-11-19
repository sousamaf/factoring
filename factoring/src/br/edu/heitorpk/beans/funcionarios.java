package br.edu.heitorpk.beans;

import java.io.Serializable;
import java.util.Calendar;

public class funcionarios extends pessoa_fisica implements Serializable{
	
	private int id_funcionario;
	private boolean gerente;
	private float salario;
	private Calendar data_de_entrada;
	private Calendar data_de_saida;
	private controle_de_caixa id_caixa;
	
	public funcionarios() {
		super();
		
	}
	public funcionarios(int cpf, int rg, String sexo, String nome,
			Calendar data_de_nascimento) {
		super(cpf, rg, sexo, nome, data_de_nascimento);
		
	}
	public funcionarios(int id_cliente, String nome, String email,
			String login, String senha, endereco cep) {
		super(id_cliente, nome, email, login, senha, cep);
		
	}
	public int getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public boolean isGerente() {
		return gerente;
	}
	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Calendar getData_de_entrada() {
		return data_de_entrada;
	}
	public void setData_de_entrada(Calendar data_de_entrada) {
		this.data_de_entrada = data_de_entrada;
	}
	public Calendar getData_de_saida() {
		return data_de_saida;
	}
	public void setData_de_saida(Calendar data_de_saida) {
		this.data_de_saida = data_de_saida;
	}
	public controle_de_caixa getId_caixa() {
		return id_caixa;
	}
	public void setId_caixa(controle_de_caixa id_caixa) {
		this.id_caixa = id_caixa;
	}
	
	
}
