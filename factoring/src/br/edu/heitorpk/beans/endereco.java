package br.edu.heitorpk.beans;

import java.io.Serializable;


public class endereco implements Serializable{
	
private int id_endereco;
private int cep;
private String quadra;
private int alameda;
private int lote;
private int telefone;
private String referencia;
private cidade id_cidade;


public endereco() {
	super();
}


public endereco(int id_endereco, int cep, String quadra, int alameda, int lote,
		int telefone, String referencia, cidade id_cidade) {
	super();
	this.id_endereco = id_endereco;
	this.cep = cep;
	this.quadra = quadra;
	this.alameda = alameda;
	this.lote = lote;
	this.telefone = telefone;
	this.referencia = referencia;
	this.id_cidade = id_cidade;
}


public int getId_endereco() {
	return id_endereco;
}


public void setId_endereco(int id_endereco) {
	this.id_endereco = id_endereco;
}


public int getCep() {
	return cep;
}


public void setCep(int cep) {
	this.cep = cep;
}


public String getQuadra() {
	return quadra;
}


public void setQuadra(String quadra) {
	this.quadra = quadra;
}


public int getAlameda() {
	return alameda;
}


public void setAlameda(int alameda) {
	this.alameda = alameda;
}


public int getLote() {
	return lote;
}


public void setLote(int lote) {
	this.lote = lote;
}


public int getTelefone() {
	return telefone;
}


public void setTelefone(int telefone) {
	this.telefone = telefone;
}


public String getReferencia() {
	return referencia;
}


public void setReferencia(String referencia) {
	this.referencia = referencia;
}


public cidade getId_cidade() {
	return id_cidade;
}


public void setId_cidade(cidade id_cidade) {
	this.id_cidade = id_cidade;
}




}
