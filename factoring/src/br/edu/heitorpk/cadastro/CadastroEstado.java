package br.edu.heitorpk.cadastro;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.estado;
import br.edu.heitorpk.daos.estadoDAO;


@ManagedBean(name="cadastroEstado")
@ViewScoped
public class CadastroEstado {

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
