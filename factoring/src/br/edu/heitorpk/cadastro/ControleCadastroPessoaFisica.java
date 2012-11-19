package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.heitorpk.daos.cidadeDAO;
import br.edu.heitorpk.daos.enderecoDAO;
import br.edu.heitorpk.daos.estadoDAO;
import br.edu.heitorpk.daos.funcionariosDAO;
import br.edu.heitorpk.daos.pessoa_fisicaDAO;

@ManagedBean (name = "ControleCadastroPessoaFisica")
@ViewScoped
public class ControleCadastroPessoaFisica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	CadastroCidade cidade = null;
	CadastroEndereco endereco = null;
	CadastroEstado estado = null;
	CadastroFuncionario funcionario = null;
	CadastroPessoaFisica fisica = null;
	
	cidadeDAO cid = null;
	enderecoDAO end = null;
	estadoDAO est = null;
	funcionariosDAO  fun= null;
	pessoa_fisicaDAO fis = null;
	
	
	
public ControleCadastroPessoaFisica() {
	 cidade = new CadastroCidade();
	 endereco = new CadastroEndereco();
	 estado = new CadastroEstado();
	 funcionario = new CadastroFuncionario();
	 fisica = new CadastroPessoaFisica();
	 
	cid = new cidadeDAO();
	end = new enderecoDAO();
	est = new estadoDAO();
	fun= new funcionariosDAO();
	fis = new pessoa_fisicaDAO();
	}


public CadastroCidade getCidade() {
		return cidade;
	}


	public void setCidade(CadastroCidade cidade) {
		this.cidade = cidade;
	}


	public CadastroEndereco getEndereco() {
		return endereco;
	}


	public void setEndereco(CadastroEndereco endereco) {
		this.endereco = endereco;
	}


	public CadastroEstado getEstado() {
		return estado;
	}


	public void setEstado(CadastroEstado estado) {
		this.estado = estado;
	}


	public CadastroFuncionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(CadastroFuncionario funcionario) {
		this.funcionario = funcionario;
	}


	public CadastroPessoaFisica getFisica() {
		return fisica;
	}


	public void setFisica(CadastroPessoaFisica fisica) {
		this.fisica = fisica;
	}
	public String salvar(){
		cid.inserir(cidade.getCidade());
		end.inserir(endereco.getEndereco());
		est.inserir(estado.getEstado());
		fun.inserir(funcionario.getFuncionarios());
		fis.inserir(fisica.getPessoa_fisica());
		return "Sucesso";
	}

	
}

