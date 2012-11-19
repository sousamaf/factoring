package br.edu.heitorpk.realizandoEmprestimo;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.beans.status_pessoa;
import br.edu.heitorpk.daos.status_pessoaDAO;



public class Status_Emprestimo implements Serializable{

	//DAOs
		private status_pessoaDAO status_pessoaDAO;
		
		//Beans
		private status_pessoa status_pessoa;
		
		public  void StatusEmprestimo(){
			status_pessoaDAO = new status_pessoaDAO();
			status_pessoa = new status_pessoa();		
		}
		
		public void sPessoa(){
			boolean resultado;
			
			resultado = status_pessoaDAO.inserir(status_pessoa);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
			
		}

		public status_pessoaDAO getStatus_pessoaDAO() {
			return status_pessoaDAO;
		}

		public void setStatus_pessoaDAO(status_pessoaDAO status_pessoaDAO) {
			this.status_pessoaDAO = status_pessoaDAO;
		}

		public status_pessoa getStatus_pessoa() {
			return status_pessoa;
		}

		public void setStatus_pessoa(status_pessoa status_pessoa) {
			this.status_pessoa = status_pessoa;
		}
		
}
