package br.edu.heitorpk.cadastroCheque;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.heitorpk.beans.cheques;
import br.edu.heitorpk.beans.status_cheque;
import br.edu.heitorpk.daos.chequesDAO;
import br.edu.heitorpk.daos.status_chequeDAO;
import br.edu.heitorpk.daos.tipo_chequeDAO;
@ManagedBean (name="controleCheque")
@ViewScoped
public class ControleCheque implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CadastroCheque cheque= null;
	Status_Cheque status = null;
	Tipo tipo = null;
	
	chequesDAO cheq =null;
	status_chequeDAO sta =null;
	tipo_chequeDAO tip = null;
	
	
	public ControleCheque() {
		cheque= new CadastroCheque();
		status = new Status_Cheque();
		tipo = new Tipo();
		
		cheq = new chequesDAO();
		 sta = new status_chequeDAO();
		tip = new tipo_chequeDAO();
	}

	public CadastroCheque getCheque() {
		return cheque;
	}

	public void setCheque(CadastroCheque cheque) {
		this.cheque = cheque;
	}

	public Status_Cheque getStatus() {
		return status;
	}

	public void setStatus(Status_Cheque status) {
		this.status = status;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public String salvarCheque(){
		cheq.inserir(cheque.getCheques());
		 sta.inserir(status.getStatus_cheque());
		tip.inserir(tipo.getTipo_cheque());
		return "Sucesso";
	}
	
	
}
