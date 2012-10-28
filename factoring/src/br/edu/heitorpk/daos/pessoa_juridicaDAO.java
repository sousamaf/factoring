package br.edu.heitorpk.daos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.pessoa_fisica;
import br.edu.heitorpk.classes.pessoa_juridica;
import br.edu.heitorpk.conexao.Conexao;


public class pessoa_juridicaDAO {

	  @SuppressWarnings("finally")
	  public boolean excluir(pessoa_juridica pessoa_juridica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM pessoa_juridica WHERE id_cliente=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, pessoa_juridica.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM pessoa_fisica WHERE id_cliente=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, pessoa_juridica.getId_cliente());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_juridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

	public boolean atualizar(pessoa_juridica pessoa_juridica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    
	    String query = "UPDATE pessoa_juridica SET nome_empresa=?, cpnj=?" 
	    + "UPDATE pessoa SET email=?,login=? senha=?, id_cliente=? "
	            + "WHERE pessoa_id_cliente=?";
	    
	    con.transacao();
	    con.preparar(query);
	    try
	    {
	    	con.getPstmt().setString(1, pessoa_juridica.getNome_empresa());
		      con.getPstmt().setInt(2, pessoa_juridica.getCnpj());
		      con.getPstmt().setString(3, pessoa_juridica.getEmail());
		      con.getPstmt().setString(4, pessoa_juridica.getLogin());
		      con.getPstmt().setString(5, pessoa_juridica.getSenha());
		      con.getPstmt().setInt(6, pessoa_juridica.getId_cliente());
	          res = con.executeUpdate();
	      if (res = con.executeUpdate())
	      {
	        query = "UPDATE pessoa_juridica SET nome_empresa=?, cpnj=? WHERE id_cliente=?";
	        con.preparar(query);
	        con.getPstmt().setString(1, pessoa_juridica.getNome_empresa());
		      con.getPstmt().setInt(2, pessoa_juridica.getCnpj());
		      con.getPstmt().setString(3, pessoa_juridica.getEmail());
		      con.getPstmt().setString(4, pessoa_juridica.getLogin());
		      con.getPstmt().setString(5, pessoa_juridica.getSenha());
		      con.getPstmt().setInt(6, pessoa_juridica.getId_cliente());
	          res = con.executeUpdate();
	        res = con.executeUpdate();
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return(res);
	    }
	  }

	  @SuppressWarnings("finally")
	public ArrayList<pessoa_juridica> buscar()
	  {
	    ArrayList<pessoa_juridica> res = new ArrayList<pessoa_juridica>();
	    Conexao con = new Conexao();
	    String query = "SELECT pessoa_juridica, cnjp FROM uf ORDER BY cnpj";

	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        pessoa_juridica juridica = new pessoa_juridica();
	        juridica.setCnpj(rs.getInt("cnpj"));
	        res.add(juridica);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_juridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechar();
	      return (res);
	    }
	  }
}
