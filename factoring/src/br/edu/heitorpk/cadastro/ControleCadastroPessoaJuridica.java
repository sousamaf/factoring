package br.edu.heitorpk.cadastro;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.heitorpk.daos.cidadeDAO;
import br.edu.heitorpk.daos.enderecoDAO;
import br.edu.heitorpk.daos.estadoDAO;
import br.edu.heitorpk.daos.funcionariosDAO;
import br.edu.heitorpk.daos.pessoa_juridicaDAO;

@ManagedBean (name = "ControleCadastroPessoaJuridica")
@ViewScoped
public class ControleCadastroPessoaJuridica implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	CadastroCidade cidade = null;
	CadastroEndereco endereco = null;
	CadastroEstado estado = null;
	CadastroFuncionario funcionario = null;
	CadastroPessoaJuridica juridica = null;
	
	cidadeDAO cid = null;
	enderecoDAO end = null;
	estadoDAO est = null;
	funcionariosDAO  fun= null;
	pessoa_juridicaDAO jur = null;
	
	
	
public ControleCadastroPessoaJuridica() {
	 cidade = new CadastroCidade();
	 endereco = new CadastroEndereco();
	 estado = new CadastroEstado();
	 funcionario = new CadastroFuncionario();
	 juridica = new CadastroPessoaJuridica();
	 
	cid = new cidadeDAO();
	end = new enderecoDAO();
	est = new estadoDAO();
	fun= new funcionariosDAO();
	jur = new pessoa_juridicaDAO();
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


public CadastroPessoaJuridica getJuridica() {
	return juridica;
}


public void setJuridica(CadastroPessoaJuridica juridica) {
	this.juridica = juridica;
}


	public String salvar(){
		cid.inserir(cidade.getCidade());
		end.inserir(endereco.getEndereco());
		est.inserir(estado.getEstado());
		fun.inserir(funcionario.getFuncionarios());
		jur.inserir(juridica.getPessoa_juridica());
		return "Sucesso";
	}

	
}
