package br.edu.heitorpk.classes;

import javax.xml.soap.Text;

public class status_pessoa extends emprestimo{

	private String status_emprestimo;
	private Text descricao;
	
	public status_pessoa() {
		super();
	}

	public status_pessoa(String status_emprestimo, Text descicao) {
		
		this.status_emprestimo = status_emprestimo;
		this.descricao = descicao;
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

	public Text getDescicao() {
		return descricao;
	}

	public void setDescicao(Text descicao) {
		this.descricao = descicao;
	}
	
	
}
