package br.edu.heitorpk.funcionarioCuida;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.heitorpk.classes.funcionarios;
import br.edu.heitorpk.daos.agendar_horarioDAO;

@ManagedBean (name= "fAgenda")
@ViewScoped
public class agendar_horario {

	//Daos
	private agendar_horarioDAO agendar_horarioDAO;
	//Beans
	private agendar_horario agendar_horario;
	private funcionarios funcionarios;
	
	public void agenda(){
		agendar_horarioDAO = new agendar_horarioDAO();
		agendar_horario= new agendar_horario();
		funcionarios = new funcionarios();
		
	}
	
	
	public void agendarHorario(){
		boolean resultado;
		
		//resultado = agendar_horarioDAO.inserir(agendar_horario);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("asdasd"));
		
	}


	public agendar_horarioDAO getAgendar_horarioDAO() {
		return agendar_horarioDAO;
	}


	public void setAgendar_horarioDAO(agendar_horarioDAO agendar_horarioDAO) {
		this.agendar_horarioDAO = agendar_horarioDAO;
	}


	public agendar_horario getAgendar_horario() {
		return agendar_horario;
	}


	public void setAgendar_horario(agendar_horario agendar_horario) {
		this.agendar_horario = agendar_horario;
	}


	public funcionarios getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
