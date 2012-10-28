package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.status_cheque;
import br.edu.heitorpk.conexao.Conexao;

public class status_chequeDAO {
	@SuppressWarnings("finally")
	  public boolean excluir(status_cheque id)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM status_cheque WHERE cheques_id_cheque=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id.getId_cheque());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM status_cheque WHERE cheques_id_cheque=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, id.getId_cheque());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(status_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

		@SuppressWarnings("finally")
		public boolean atualizar(status_cheque status)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE status_cheque SET status_cheq=?, observacao=? "
		            + "WHERE cheques_id_cheque?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, status.getStatus_cheq());
			      con.getPstmt().setString(2, status.getObservacao());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE status_cheque SET status_cheq=?, observacao=? "
			            + "WHERE cheques_id_cheque?";
		        con.preparar(query);
		        con.getPstmt().setString(1, status.getStatus_cheq());
			      con.getPstmt().setString(2, status.getObservacao());
		          res = con.executeUpdate();
		        res = con.executeUpdate();
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(status_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<status_cheque> buscar()
		  {
		    ArrayList<status_cheque> res = new ArrayList<status_cheque>();
		    Conexao con = new Conexao();
		    String query = "SELECT status_cheque, cheques_id_cheque FROM uf ORDER BY cheques_id_cheque";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        status_cheque status = new status_cheque();
		        status.setId_cheque(rs.getInt("id_cheque"));
		        res.add(status);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(status_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
}
