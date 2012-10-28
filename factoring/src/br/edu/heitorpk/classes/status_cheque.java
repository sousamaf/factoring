package br.edu.heitorpk.classes;

import java.util.Calendar;

import javax.xml.soap.Text;

public class status_cheque extends cheques {

	private String status_cheq;
	private Text observacao;
	
	public status_cheque() {
		super();
	}

	public status_cheque(String status_cheq, Text observacao) {
		this.status_cheq = status_cheq;
		this.observacao = observacao;
	}

	
	
	public status_cheque(int id_cheque, String titular, int banco, int agencia,
			int numero_conta, int numero, int cpnf_cnpj, int telefone,
			float valor, Calendar recebimento, Calendar vencimento,
			pessoa id_cliente, tipo_cheque id_tipo, movimentacao id_movimentacao) {
		super(id_cheque, titular, banco, agencia, numero_conta, numero, cpnf_cnpj,
				telefone, valor, recebimento, vencimento, id_cliente, id_tipo,
				id_movimentacao);
		
	}

	public Text getObservacao() {
		return observacao;
	}

	public void setObservacao(Text observacao) {
		this.observacao = observacao;
	}

	public String getStatus_cheq() {
		return status_cheq;
	}

	public void setStatus_cheq(String status_cheq) {
		this.status_cheq = status_cheq;
	}
	
	
	
}
