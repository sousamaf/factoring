package br.edu.heitorpk.classes;

import java.util.Calendar;

public class pessoa_fisica extends pessoa{

	
	private int cpf;
	private int rg;
	private String sexo;
	private String nome;
	private Calendar data_de_nascimento;
	
	
	public pessoa_fisica() {
		super();
	}

	public pessoa_fisica(int cpf, int rg, String sexo,String nome,
			Calendar data_de_nascimento) {
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.data_de_nascimento = data_de_nascimento;
	}




	public pessoa_fisica(int id_cliente, String nome, String email,
			String login, String senha, endereco cep) {
		super(id_cliente, nome, email, login, senha, cep);
		
	}

	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public int getRg() {
		return rg;
	}


	public void setRg(int rg) {
		this.rg = rg;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Calendar getData_de_nascimento() {
		return data_de_nascimento;
	}


	public void setData_de_nascimento(Calendar data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
