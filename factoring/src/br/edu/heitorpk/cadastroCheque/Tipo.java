package br.edu.heitorpk.cadastroCheque;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.tipo_cheque;
import br.edu.heitorpk.daos.tipo_chequeDAO;

public class Tipo implements Serializable{
	//DAOs
		private tipo_chequeDAO tipo_chequeDAO;
		
		//Beans
		private tipo_cheque tipo_cheque;
		
		public Tipo(){
			tipo_chequeDAO = new tipo_chequeDAO();
			tipo_cheque = new tipo_cheque();		
		}
		
		public void cadastrarEstado(){
			boolean resultado;
			
			resultado = tipo_chequeDAO.inserir(tipo_cheque);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
			
		}

		public tipo_chequeDAO getTipo_chequeDAO() {
			return tipo_chequeDAO;
		}

		public void setTipo_chequeDAO(tipo_chequeDAO tipo_chequeDAO) {
			this.tipo_chequeDAO = tipo_chequeDAO;
		}

		public tipo_cheque getTipo_cheque() {
			return tipo_cheque;
		}

		public void setTipo_cheque(tipo_cheque tipo_cheque) {
			this.tipo_cheque = tipo_cheque;
		}
		
}
