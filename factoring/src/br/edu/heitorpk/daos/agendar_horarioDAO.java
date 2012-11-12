package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.agendar_horario;
import br.edu.heitorpk.classes.cidade;
import br.edu.heitorpk.classes.fiador;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.conexao.Conexao;

public class agendar_horarioDAO implements Serializable{
	 @SuppressWarnings("finally")
	  public boolean excluir(agendar_horario agenda)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM agendar_horario WHERE id_cliente=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, agenda.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM agendar_horario WHERE id_cliente=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, agenda.getId_cliente());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(agendar_horarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }
	 @SuppressWarnings("finally")
		public boolean inserir(agendar_horario agenda)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO agendar_horario (data, hora, id_funcionario) "
		            + "VALUES (?, ?, ?)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setLong(1, agenda.getData().getTimeInMillis());
		      con.getPstmt().setLong(2, agenda.getHora().getTimeInMillis());
		      con.getPstmt().setInt(3, agenda.getId_funcionario().getId_funcionario());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(agendar_horarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }

		@SuppressWarnings("finally")
		public boolean atualizar(agendar_horario agendar)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE agendar_horario SET data=?,hora=?, id_funcionario=? "
		            + "WHERE id_cliente=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setLong(1, agendar.getData().getTimeInMillis());
			      con.getPstmt().setLong(2, agendar.getHora().getTimeInMillis());
			      con.getPstmt().setInt(3, agendar.getId_cliente());
			      con.getPstmt().setInt(4, agendar.getId_funcionario().getId_funcionario());
			      
		          res = con.executeUpdate();
		      
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(agendar_horarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<agendar_horario> buscar()
		  {
		    ArrayList<agendar_horario> res = new ArrayList<agendar_horario>();
		    Conexao con = new Conexao();
		    String query = "SELECT hora, data FROM agendar_horario ORDER BY data";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        agendar_horario h = new agendar_horario();
		        Date a;
		        a = rs.getDate("data");
		        a = rs.getDate("hora");
		        res.add(h);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(agendar_horarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
}
