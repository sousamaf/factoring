package br.edu.heitorpk.funcionarioCuida;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.daos.controle_de_caixaDAO;
@ManagedBean (name= "fCaixa")
@ViewScoped
public class Controle_de_caixa {

	//Daos
	private controle_de_caixaDAO controle_de_caixaDAO;
	//Beans
	private controle_de_caixa  caixa;
	
	public void caixa(){
		controle_de_caixaDAO = new controle_de_caixaDAO();
		caixa = new controle_de_caixa();
	}
	
	
	public void Caixa(){
		boolean resultado;
		
		resultado = controle_de_caixaDAO.inserir(caixa);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
	}


	public controle_de_caixaDAO getControle_de_caixaDAO() {
		return controle_de_caixaDAO;
	}


	public void setControle_de_caixaDAO(controle_de_caixaDAO controle_de_caixaDAO) {
		this.controle_de_caixaDAO = controle_de_caixaDAO;
	}


	public controle_de_caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(controle_de_caixa caixa) {
		this.caixa = caixa;
	}
	
	
}
