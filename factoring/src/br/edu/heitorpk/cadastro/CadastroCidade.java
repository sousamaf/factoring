package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.beans.cidade;
import br.edu.heitorpk.daos.cidadeDAO;


public class CadastroCidade implements Serializable {

	// DAOs
		private cidadeDAO cidadeDAO;

		// Beans
		private cidade cidade;

		public CadastroCidade(){
			cidadeDAO = new cidadeDAO();
			cidade = new cidade();		
		}
		
		public void cadastrarEstado(){
			boolean resultado;
			
			resultado = cidadeDAO.inserir(cidade);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
			
		}

		public cidadeDAO getCidadeDAO() {
			return cidadeDAO;
		}

		public void setCidadeDAO(cidadeDAO cidadeDAO) {
			this.cidadeDAO = cidadeDAO;
		}

		public cidade getCidade() {
			return cidade;
		}

		public void setCidade(cidade cidade) {
			this.cidade = cidade;
		}
		
}
