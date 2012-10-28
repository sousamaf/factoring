package br.edu.heitorpk.classes;


public class pessoa_juridica extends pessoa{

	private int cnpj;
	private String nome_empresa;
	
	
	public pessoa_juridica() {
		super();
	}


	public pessoa_juridica(int cnpj, String nome_empresa) {
		
		this.cnpj = cnpj;
		this.nome_empresa = nome_empresa;
	}


	public pessoa_juridica(int id_cliente, String nome, String email,
			String login, String senha, endereco cep) {
		super(id_cliente, nome, email, login, senha, cep);
		
	}


	public int getCnpj() {
		return cnpj;
	}


	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}


	public String getNome_empresa() {
		return nome_empresa;
	}


	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}


	
}
