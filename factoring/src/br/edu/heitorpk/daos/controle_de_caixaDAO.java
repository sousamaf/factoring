package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.cheques;
import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.conexao.Conexao;

public class controle_de_caixaDAO {
	@SuppressWarnings("finally")
	  public boolean excluir(controle_de_caixa caixa)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM controle_de_caixa WHERE id_caixa=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, caixa.getId_caixa());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM controle_de_caixa WHERE id_caixa=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, caixa.getId_caixa());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(controle_de_caixaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }
	 @SuppressWarnings("finally")
		public boolean inserir(controle_de_caixa caixa)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO controle_de_caixa (entrada, saldo, saida ) "
		            + "VALUES (?, ?, ?,)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setLong(1, caixa.getEntrada().getTimeInMillis());
		      con.getPstmt().setFloat(2, caixa.getSaldo());
		      con.getPstmt().setLong(3, caixa.getSaida().getTimeInMillis());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(controle_de_caixaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(controle_de_caixa caixa)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE controle_de_caixa SET entrada=?, saldo=? saida=?"
		            + "WHERE id_caixa=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setLong(1, caixa.getEntrada().getTimeInMillis());
			      con.getPstmt().setFloat(2, caixa.getSaldo());
			      con.getPstmt().setLong(3, caixa.getSaida().getTimeInMillis());
			      con.getPstmt().setInt(4, caixa.getId_caixa());
		          res = con.executeUpdate();
		     
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(controle_de_caixaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<controle_de_caixa> buscar()
		  {
		    ArrayList<controle_de_caixa> res = new ArrayList<controle_de_caixa>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_caixa, entrada, saldo, saida FROM controle_de_caixa ";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        controle_de_caixa caixa = new controle_de_caixa();
		        caixa.setId_caixa(rs.getInt("id_caixa"));
		        caixa.setEntrada(rs.getDate("entrada"));
		        caixa.setSaldo(rs.getFloat("saldo"));
		        caixa.setSaida(rs.getDate("saida"));
		        res.add(caixa);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(controle_de_caixaDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
}
