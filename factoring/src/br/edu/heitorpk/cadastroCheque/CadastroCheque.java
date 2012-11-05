package br.edu.heitorpk.cadastroCheque;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.cheques;
import br.edu.heitorpk.classes.movimentacao;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.classes.tipo_cheque;
import br.edu.heitorpk.daos.chequesDAO;
@ManagedBean (name= "CadastroCheque")
@ViewScoped
public class CadastroCheque {

	//DAOs
		private chequesDAO chequesDAO;
		
		//Beans
		private cheques cheques;
		private movimentacao movimentacao;
		private pessoa pessoa;
		private tipo_cheque tipo_cheque;
		
		public CadastroCheque(){
			chequesDAO = new chequesDAO();
			cheques = new cheques();
			movimentacao= new movimentacao();
			pessoa = new pessoa();
			tipo_cheque = new tipo_cheque();
		}
		
		public void cadastrarCheque(){
			boolean resultado;
			
			resultado = chequesDAO.inserir(cheques);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
			
		}
		

		public tipo_cheque getTipo_cheque() {
			return tipo_cheque;
		}

		public void setTipo_cheque(tipo_cheque tipo_cheque) {
			this.tipo_cheque = tipo_cheque;
		}

		public movimentacao getMovimentacao() {
			return movimentacao;
		}

		public void setMovimentacao(movimentacao movimentacao) {
			this.movimentacao = movimentacao;
		}

		public pessoa getPessoa() {
			return pessoa;
		}

		public void setPessoa(pessoa pessoa) {
			this.pessoa = pessoa;
		}

		public chequesDAO getChequesDAO() {
			return chequesDAO;
		}

		public void setChequesDAO(chequesDAO chequesDAO) {
			this.chequesDAO = chequesDAO;
		}

		public cheques getCheques() {
			return cheques;
		}

		public void setCheques(cheques cheques) {
			this.cheques = cheques;
		}
		
	
}