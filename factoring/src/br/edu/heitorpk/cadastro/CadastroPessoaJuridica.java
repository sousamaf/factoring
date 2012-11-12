package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.classes.pessoa_juridica;
import br.edu.heitorpk.daos.pessoa_juridicaDAO;


public class CadastroPessoaJuridica implements Serializable{
	// DAOs
	private pessoa_juridicaDAO pessoa_juridicaDAO;

	// Beans
	private pessoa_juridica pessoa_juridica;
	private pessoa pessoa;

	public CadastroPessoaJuridica(){
		pessoa_juridicaDAO = new pessoa_juridicaDAO();
		pessoa_juridica = new pessoa_juridica();
		pessoa = new pessoa();
	}
	
	public void cadastrarEstado(){
		boolean resultado;
		
		resultado = pessoa_juridicaDAO.inserir(pessoa_juridica);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
	}

	public pessoa_juridicaDAO getPessoa_juridicaDAO() {
		return pessoa_juridicaDAO;
	}

	public void setPessoa_juridicaDAO(pessoa_juridicaDAO pessoa_juridicaDAO) {
		this.pessoa_juridicaDAO = pessoa_juridicaDAO;
	}

	public pessoa_juridica getPessoa_juridica() {
		return pessoa_juridica;
	}

	public void setPessoa_juridica(pessoa_juridica pessoa_juridica) {
		this.pessoa_juridica = pessoa_juridica;
	}

	public pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
