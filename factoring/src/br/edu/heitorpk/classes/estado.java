package br.edu.heitorpk.classes;


public class estado {
private String id_uf;
private String nome;

public estado() {
	super();
}

public estado(String id_uf, String nome) {
	super();
	this.id_uf = id_uf;
	this.nome = nome;
}

public String getId_uf() {
	return id_uf;
}

public void setId_uf(String id_uf) {
	this.id_uf = id_uf;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}



}
