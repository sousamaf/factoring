package br.edu.heitorpk.classes;

import java.io.Serializable;


public class pessoa implements Serializable{
private int id_cliente;
private String email;
private String login;
private String senha;
private endereco cep;



public pessoa() {
	super();
}



public pessoa(int id_cliente, String nome, String email, String login,
		String senha, endereco cep) {
	super();
	this.id_cliente = id_cliente;
	this.email = email;
	this.login = login;
	this.senha = senha;
	this.cep = cep;
}



public int getId_cliente() {
	return id_cliente;
}



public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
}




public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getLogin() {
	return login;
}



public void setLogin(String login) {
	this.login = login;
}



public String getSenha() {
	return senha;
}



public void setSenha(String senha) {
	this.senha = senha;
}



public endereco getCep() {
	return cep;
}



public void setCep(endereco cep) {
	this.cep = cep;
}




}
