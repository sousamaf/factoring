package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.agendar_horario;
import br.edu.heitorpk.classes.fiador;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.conexao.Conexao;

public class agendar_horarioDAO {
	 @SuppressWarnings("finally")
	  public boolean excluir(agendar_horario agenda)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM agendar_horario WHERE pessoa_id_cliente=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, agenda.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM agendar_horario WHERE pessoa_id_cliente=?";
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
		public boolean atualizar(agendar_horario agendar)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE agendar_horario SET data=?,hora=?"
		            + "WHERE pessoa_id_cliente=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setLong(1, agendar.getData().getTimeInMillis());
			      con.getPstmt().setLong(2, agendar.getHora().getTimeInMillis());
			      con.getPstmt().setInt(3, agendar.getId_funcionario());
			      
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE agendar_horario SET data=?,hora=?"
			            + "WHERE pessoa_id_cliente=?";
		        con.preparar(query);
		        con.getPstmt().setLong(1, agendar.getData().getTimeInMillis());
			      con.getPstmt().setLong(2, agendar.getHora().getTimeInMillis());
			      con.getPstmt().setInt(3, agendar.getId_funcionario());
		          res = con.executeUpdate();
		        res = con.executeUpdate();
		      }
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
		    String query = "SELECT agendar_horario, data FROM uf ORDER BY data";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        agendar_horario h = new agendar_horario();
		        h.setData(rs.getDate("data"));
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
