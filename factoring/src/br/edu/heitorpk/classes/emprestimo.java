package br.edu.heitorpk.classes;

import java.io.Serializable;

public class emprestimo implements Serializable{

		private int id_emprestimo;
		private float comprovante_de_renda;
		private float valor_emprestimo;
		private float juros_mensal;
		private float juros_atraso;
		private movimentacao id_movimentacao;
		private pessoa id_cliente;
		
		public emprestimo() {
			super();
		}

		public emprestimo(int id_emprestimo, float comprovante_de_renda,
				float valor_emprestimo, float juros_mensal, float juros_atraso,
				movimentacao id_movimentacao, pessoa id_cliente) {
			super();
			this.id_emprestimo = id_emprestimo;
			this.comprovante_de_renda = comprovante_de_renda;
			this.valor_emprestimo = valor_emprestimo;
			this.juros_mensal = juros_mensal;
			this.juros_atraso = juros_atraso;
			this.id_movimentacao = id_movimentacao;
			this.id_cliente = id_cliente;
		}

		public int getId_emprestimo() {
			return id_emprestimo;
		}

		public void setId_emprestimo(int id_emprestimo) {
			this.id_emprestimo = id_emprestimo;
		}

		public float getComprovante_de_renda() {
			return comprovante_de_renda;
		}

		public void setComprovante_de_renda(float comprovante_de_renda) {
			this.comprovante_de_renda = comprovante_de_renda;
		}

		public float getValor_emprestimo() {
			return valor_emprestimo;
		}

		public void setValor_emprestimo(float valor_emprestimo) {
			this.valor_emprestimo = valor_emprestimo;
		}

		public float getJuros_mensal() {
			return juros_mensal;
		}

		public void setJuros_mensal(float juros_mensal) {
			this.juros_mensal = juros_mensal;
		}

		public float getJuros_atraso() {
			return juros_atraso;
		}

		public void setJuros_atraso(float juros_atraso) {
			this.juros_atraso = juros_atraso;
		}

		public movimentacao getId_movimentacao() {
			return id_movimentacao;
		}

		public void setId_movimentacao(movimentacao id_movimentacao) {
			this.id_movimentacao = id_movimentacao;
		}

		public pessoa getId_cliente() {
			return id_cliente;
		}

		public void setId_cliente(pessoa id_cliente) {
			this.id_cliente = id_cliente;
		}
		
		
}
