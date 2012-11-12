package br.edu.heitorpk.classes;

import java.io.Serializable;


public class estado implements Serializable{
private String id_uf;
private String estado;

public estado() {
	super();
}

public estado(String id_uf, String nome) {
	super();
	this.id_uf = id_uf;
	this.estado = estado;
}

public String getId_uf() {
	return id_uf;
}

public void setId_uf(String id_uf) {
	this.id_uf = id_uf;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}



}
