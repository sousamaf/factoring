package br.edu.heitorpk.funcionarioCuida;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.classes.movimentacao;
import br.edu.heitorpk.daos.movimentacaoDAO;
@ManagedBean (name= "fMovimentacao")
@ViewScoped
public class Movimentacao {

	//Daos
	private movimentacaoDAO movimentacaoDAO;
	//Beans
	private movimentacao movimentacao;
	
	private controle_de_caixa  caixa;
	
	public void movimentacao(){
		movimentacaoDAO = new movimentacaoDAO();
		movimentacao = new movimentacao();
		caixa = new controle_de_caixa();
	}
	


	public movimentacaoDAO getMovimentacaoDAO() {
		return movimentacaoDAO;
	}


	public void setMovimentacaoDAO(movimentacaoDAO movimentacaoDAO) {
		this.movimentacaoDAO = movimentacaoDAO;
	}


	public movimentacao getMovimentacao() {
		return movimentacao;
	}


	public void setMovimentacao(movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}


	public controle_de_caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(controle_de_caixa caixa) {
		this.caixa = caixa;
	}
	
}
