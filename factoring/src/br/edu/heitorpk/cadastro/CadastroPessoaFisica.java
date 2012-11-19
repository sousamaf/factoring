package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.beans.pessoa;
import br.edu.heitorpk.beans.pessoa_fisica;
import br.edu.heitorpk.daos.pessoa_fisicaDAO;

public class CadastroPessoaFisica implements Serializable{
	// DAOs
				private pessoa_fisicaDAO pessoa_fisicaDAO;

				// Beans
				private pessoa_fisica pessoa_fisica;
				private pessoa pessoa;

				public CadastroPessoaFisica(){
					pessoa_fisicaDAO = new pessoa_fisicaDAO();
					pessoa_fisica = new pessoa_fisica();
					pessoa = new pessoa();
				}
				
				public void cadastrarEstado(){
					boolean resultado;
					
					resultado = pessoa_fisicaDAO.inserir(pessoa_fisica);
					
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
					
				}

				public pessoa_fisicaDAO getPessoa_fisicaDAO() {
					return pessoa_fisicaDAO;
				}

				public void setPessoa_fisicaDAO(pessoa_fisicaDAO pessoa_fisicaDAO) {
					this.pessoa_fisicaDAO = pessoa_fisicaDAO;
				}

				public pessoa_fisica getPessoa_fisica() {
					return pessoa_fisica;
				}

				public void setPessoa_fisica(pessoa_fisica pessoa_fisica) {
					this.pessoa_fisica = pessoa_fisica;
				}

				public pessoa getPessoa() {
					return pessoa;
				}

				public void setPessoa(pessoa pessoa) {
					this.pessoa = pessoa;
				}
				
}
