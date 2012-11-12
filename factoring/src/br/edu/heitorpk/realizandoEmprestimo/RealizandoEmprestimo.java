package br.edu.heitorpk.realizandoEmprestimo;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.emprestimo;
import br.edu.heitorpk.classes.movimentacao;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.daos.emprestimoDAO;

@ManagedBean (name="rEmprestimo")
@ViewScoped
public class RealizandoEmprestimo implements Serializable{
	
	//DAOs
	private emprestimoDAO emprestimoDAO;
	
	//Beans
	private emprestimo emprestimo;
	private movimentacao movimentacao;
	private pessoa pessoa;
	
	public RealizandoEmprestimo(){
		emprestimoDAO = new emprestimoDAO();
		emprestimo = new emprestimo();
		movimentacao= new movimentacao();
		pessoa = new pessoa();
	}
	
	public void rEmprestimo(){
		boolean resultado;
		
		resultado = emprestimoDAO.inserir(emprestimo);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
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

	public emprestimoDAO getEmprestimoDAO() {
		return emprestimoDAO;
	}

	public void setEmprestimoDAO(emprestimoDAO emprestimoDAO) {
		this.emprestimoDAO = emprestimoDAO;
	}

	public emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}
