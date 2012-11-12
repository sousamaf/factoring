	package br.edu.heitorpk.classes;

import java.io.Serializable;
import java.util.Calendar;

public class agendar_horario extends pessoa implements Serializable{
	
	private Calendar data;
	private Calendar hora;
	private funcionarios id_funcionario;

	public agendar_horario() {
		super();
	}

	public agendar_horario(Calendar data, Calendar hora,
			funcionarios id_funcionario) {
		this.data = data;
		this.hora = hora;
		this.id_funcionario = id_funcionario;
	}

	
	
	public agendar_horario(int id_cliente, String nome, String email,
			String login, String senha, endereco cep) {
		super(id_cliente, nome, email, login, senha, cep);
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public funcionarios getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(funcionarios id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	

}
