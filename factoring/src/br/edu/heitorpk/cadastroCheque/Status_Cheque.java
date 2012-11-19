package br.edu.heitorpk.cadastroCheque;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.beans.status_cheque;
import br.edu.heitorpk.daos.status_chequeDAO;

public class Status_Cheque implements Serializable {

	//DAOs
		private status_chequeDAO status_chequeDAO;
		
		//Beans
		private status_cheque status_cheque;
		
		public void Status(){
			status_chequeDAO = new status_chequeDAO();
			status_cheque = new status_cheque();		
		}
		
		
		public void cadastrarEstado(){
			boolean resultado;
			
			resultado = status_chequeDAO.inserir(status_cheque);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
			
		}

		public status_chequeDAO getStatus_chequeDAO() {
			return status_chequeDAO;
		}

		public void setStatus_chequeDAO(status_chequeDAO status_chequeDAO) {
			this.status_chequeDAO = status_chequeDAO;
		}

		public status_cheque getStatus_cheque() {
			return status_cheque;
		}

		public void setStatus_cheque(status_cheque status_cheque) {
			this.status_cheque = status_cheque;
		}
		
}
