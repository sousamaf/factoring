package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.endereco;
import br.edu.heitorpk.daos.enderecoDAO;


@ManagedBean (name="cadastroEndereco")
@ViewScoped

public class CadastroEndereco implements Serializable {
	// DAOs
			private enderecoDAO enderecoDAO;

			// Beans
			private endereco endereco;

			public CadastroEndereco(){
				enderecoDAO = new enderecoDAO();
				endereco = new endereco();		
			}
			
			public void cadastrarEstado(){
				boolean resultado;
				
				resultado = enderecoDAO.inserir(endereco);
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
				
			}

			public enderecoDAO getEnderecoDAO() {
				return enderecoDAO;
			}

			public void setEnderecoDAO(enderecoDAO enderecoDAO) {
				this.enderecoDAO = enderecoDAO;
			}

			public endereco getEndereco() {
				return endereco;
			}

			public void setEndereco(endereco endereco) {
				this.endereco = endereco;
			}
			
}
