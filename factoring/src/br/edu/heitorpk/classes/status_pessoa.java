package br.edu.heitorpk.classes;

import java.io.Serializable;



public class status_pessoa extends emprestimo implements Serializable{

	private String status_emprestimo;
	private String descricao;
	
	public status_pessoa() {
		super();
	}

	public status_pessoa(String status_emprestimo, String descricao) {
		
		this.status_emprestimo = status_emprestimo;
		this.descricao = descricao;
	}

	
	
	public status_pessoa(int id_emprestimo, float comprovante_de_renda,
			float valor_emprestimo, float juros_mensal, float juros_atraso,
			movimentacao id_movimentacao, pessoa id_cliente) {
		super(id_emprestimo, comprovante_de_renda, valor_emprestimo, juros_mensal,
				juros_atraso, id_movimentacao, id_cliente);
		
	}

	public String getStatus_emprestimo() {
		return status_emprestimo;
	}

	public void setStatus_emprestimo(String status_emprestimo) {
		this.status_emprestimo = status_emprestimo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescicao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
