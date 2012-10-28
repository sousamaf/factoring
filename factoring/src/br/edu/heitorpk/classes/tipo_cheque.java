package br.edu.heitorpk.classes;

public class tipo_cheque {

	private int id_tipo;
	private String tipo;
	
	
	public tipo_cheque() {
		super();
	}


	public tipo_cheque(int id_tipo, String tipo) {
		super();
		this.id_tipo = id_tipo;
		this.tipo = tipo;
	}


	public int getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
