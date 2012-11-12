package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.classes.funcionarios;
import br.edu.heitorpk.classes.pessoa_fisica;
import br.edu.heitorpk.daos.funcionariosDAO;
@ManagedBean (name= "CadastroFuncionario")
@ViewScoped

public class CadastroFuncionario implements Serializable{

	//Daos
	private funcionariosDAO funcionariosDAO;
	//Beans
	private funcionarios funcionarios;
	private pessoa_fisica fisica;
	private controle_de_caixa  caixa;
	
	public void cFuncionario(){
		funcionariosDAO = new funcionariosDAO();
		funcionarios = new funcionarios();
		fisica= new pessoa_fisica();
		caixa = new controle_de_caixa();
	}
	
	
	public void cadastrarFuncionario(){
		boolean resultado;
		
		resultado = funcionariosDAO.inserir(funcionarios);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
	}


	public funcionariosDAO getFuncionariosDAO() {
		return funcionariosDAO;
	}


	public void setFuncionariosDAO(funcionariosDAO funcionariosDAO) {
		this.funcionariosDAO = funcionariosDAO;
	}


	public funcionarios getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}


	public pessoa_fisica getFisica() {
		return fisica;
	}


	public void setFisica(pessoa_fisica fisica) {
		this.fisica = fisica;
	}


	public controle_de_caixa getCaixa() {
		return caixa;
	}


	public void setCaixa(controle_de_caixa caixa) {
		this.caixa = caixa;
	}
	
	

}
