package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.beans.controle_de_caixa;
import br.edu.heitorpk.beans.tipo_cheque;
import br.edu.heitorpk.conexao.Conexao;

public class tipo_chequeDAO implements Serializable{
	@SuppressWarnings("finally")
	  public boolean excluir(tipo_cheque id)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM id_tipo WHERE tipo_cheque";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id.getId_tipo());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM id_tipo WHERE tipo_cheque";
	          con.preparar(query);
	          con.getPstmt().setInt(1, id.getId_tipo());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(tipo_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

	 @SuppressWarnings("finally")
		public boolean inserir(tipo_cheque cheque)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO tipo_cheque (tipo ) "
		            + "VALUES (?)";
		    
		    con.preparar(query);
		    try
		    {
		     con.getPstmt().setString(1, cheque.getTipo());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(tipo_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(tipo_cheque tipo)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE tipo_cheque SET tipo=? "
		            + "WHERE id_tipo?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, tipo.getTipo());
		    	  con.getPstmt().setInt(2, tipo.getId_tipo());
		          res = con.executeUpdate();
		      
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(tipo_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<tipo_cheque> buscar()
		  {
		    ArrayList<tipo_cheque> res = new ArrayList<tipo_cheque>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_tipo, tipo FROM  tipo_cheque";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        tipo_cheque tipo = new tipo_cheque();
		        tipo.setId_tipo(rs.getInt("id_tipo"));
		        tipo.setTipo(rs.getString("tipo"));
		        res.add(tipo);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(tipo_chequeDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
}
