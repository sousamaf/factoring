package br.edu.heitorpk.classes;

public class cidade {
private int id_cidade;
private String nome;
private estado id_uf;


public cidade() {
	super();
}


public cidade(int id_cidade, String nome, estado id_uf) {
	super();
	this.id_cidade = id_cidade;
	this.nome = nome;
	this.id_uf = id_uf;
}


public int getId_cidade() {
	return id_cidade;
}


public void setId_cidade(int id_cidade) {
	this.id_cidade = id_cidade;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public estado getId_uf() {
	return id_uf;
}


public void setId_uf(estado id_uf) {
	this.id_uf = id_uf;
}




}
