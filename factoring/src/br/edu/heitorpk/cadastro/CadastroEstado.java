package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.beans.estado;
import br.edu.heitorpk.daos.estadoDAO;


public class CadastroEstado implements Serializable{

	// DAOs
	private estadoDAO estadoDAO;

	// Beans
	private estado estado;

	public CadastroEstado(){
		estadoDAO = new estadoDAO();
		estado = new estado();		
	}
	
	public void cadastrarEstado(){
		boolean resultado;
		
		resultado = estadoDAO.inserir(estado);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
	}
	
	public estadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(estadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public estado getEstado() {
		return estado;
	}

	public void setEstado(estado estado) {
		this.estado = estado;
	}	
	
	
	
}
