package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.status_pessoa;
import br.edu.heitorpk.conexao.Conexao;

public class status_pessoaDAO {
	@SuppressWarnings("finally")
	  public boolean excluir(status_pessoa id)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM status_pessoa WHERE emprestimo_id_emprestimo=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id.getId_emprestimo());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM status_emprestimo WHERE emprestimo_id_emprestimo=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, id.getId_emprestimo());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(status_pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

		@SuppressWarnings("finally")
		public boolean atualizar(status_pessoa status)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE status_pessoa SET status_emprestimo=?, descricao=? "
		            + "WHERE emprestimo_id_emprestimo=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, status.getStatus_emprestimo());
			      con.getPstmt().setString(2, status.getDescricao());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE status_pessoa SET status_emprestimo=?, descricao=? "
			            + "WHERE emprestimo_id_emprestimo=?";
		        con.preparar(query);
		        con.getPstmt().setString(1, status.getStatus_emprestimo());
			      con.getPstmt().setString(2, status.getDescicao());
		          res = con.executeUpdate();
		        res = con.executeUpdate();
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(status_pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<status_pessoa> buscar()
		  {
		    ArrayList<status_pessoa> res = new ArrayList<status_pessoa>();
		    Conexao con = new Conexao();
		    String query = "SELECT status_emprestimo, emprestimo_id_emprestimo FROM uf ORDER BY emprestimo_id_emprestimo";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        status_pessoa status = new status_pessoa();
		        status.setId_emprestimo(rs.getInt("id_emprestimo"));
		        res.add(status);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(status_pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
}
