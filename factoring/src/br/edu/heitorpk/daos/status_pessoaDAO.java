package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.beans.controle_de_caixa;
import br.edu.heitorpk.beans.status_pessoa;
import br.edu.heitorpk.conexao.Conexao;

public class status_pessoaDAO implements Serializable{
	@SuppressWarnings("finally")
	  public boolean excluir(status_pessoa id)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM status_pessoa WHERE id_emprestimo=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id.getId_emprestimo());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM status_emprestimo WHERE id_emprestimo=?";
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
		public boolean inserir(status_pessoa id)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO status_cheque (status_emprestimo, descricao) "
		            + "VALUES (?, ?)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setString(1, id.getStatus_emprestimo());
		      con.getPstmt().setString(2, id.getDescricao());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(status_pessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(status_pessoa status)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE emprestimo SET comprovante_de_renda=?, valor_emprestimo=?, juros_mensal=?, juros_atraso=?" +
		    		"id_cliente, id_movimentacao "
		            + "WHERE id_emprestimo=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setFloat(1, status.getComprovante_de_renda());
			      con.getPstmt().setFloat(2, status.getValor_emprestimo());
			      con.getPstmt().setFloat(3, status.getJuros_atraso());
			      con.getPstmt().setFloat(4, status.getJuros_mensal());
			      con.getPstmt().setInt(5, status.getId_emprestimo());
			      con.getPstmt().setInt(6, status.getId_cliente().getId_cliente());
			      con.getPstmt().setInt(7, status.getId_movimentacao().getId_movimentacao());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE status_pessoa SET status_emprestimo=?, descricao=? "
			            + "WHERE id_emprestimo=?";
		        con.preparar(query);
		        con.getPstmt().setString(1, status.getStatus_emprestimo());
			      con.getPstmt().setString(2, status.getDescricao());
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
		    String query = "SELECT  status_emprestimo,id_emprestimo FROM status_pessoa";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        status_pessoa status = new status_pessoa();
		        status.setId_emprestimo(rs.getInt("id_emprestimo"));
		        status.setStatus_emprestimo(rs.getString("status_emprestimo"));
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
