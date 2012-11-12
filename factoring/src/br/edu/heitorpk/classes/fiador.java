package br.edu.heitorpk.classes;

import java.io.Serializable;

public class fiador implements Serializable{

		private int id_fiador;
		private pessoa id_cliente;
		
		public fiador() {
			super();
		}

		public fiador(int id_fiador, pessoa id_cliente) {
			super();
			this.id_fiador = id_fiador;
			this.id_cliente = id_cliente;
		}

		public int getId_fiador() {
			return id_fiador;
		}

		public void setId_fiador(int id_fiador) {
			this.id_fiador = id_fiador;
		}

		public pessoa getId_cliente() {
			return id_cliente;
		}

		public void setId_cliente(pessoa id_cliente) {
			this.id_cliente = id_cliente;
		}
		
		
}
