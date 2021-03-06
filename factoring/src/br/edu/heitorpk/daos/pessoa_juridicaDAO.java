package br.edu.heitorpk.daos;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.beans.controle_de_caixa;
import br.edu.heitorpk.beans.fiador;
import br.edu.heitorpk.beans.pessoa;
import br.edu.heitorpk.beans.pessoa_fisica;
import br.edu.heitorpk.beans.pessoa_juridica;
import br.edu.heitorpk.conexao.Conexao;


public class pessoa_juridicaDAO implements Serializable{
/*
	public static void main(String args[]){
		pessoa_juridica j= new pessoa_juridica();
		
		j.setCnpj(9329323);
		j.setNome_empresa("HeitorPK");
		//j.setId_cliente(1);
		
		pessoa_juridicaDAO d = new pessoa_juridicaDAO();
		d.inserir(j);
		//d.excluir(j);
	}
	*/
	  @SuppressWarnings("finally")
	  public boolean excluir(pessoa_juridica pessoa_juridica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM pessoa_juridica WHERE pessoa_id_cliente=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, pessoa_juridica.getId_cliente());
	      res = con.executeUpdate();
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM pessoa_fisica WHERE pessoa_id_cliente=?";
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
	  @SuppressWarnings("finally")
	  public boolean inserir(pessoa_juridica juridica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "INSERT INTO pessoa_juridica (cnpj, nome_empresa ) "
	            + "VALUES (?,?)";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, juridica.getCnpj());
	      con.getPstmt().setString(2, juridica.getNome_empresa());
	      
	      
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	    	
	      Logger.getLogger(pessoa_juridicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	@SuppressWarnings("finally")
	public boolean atualizar(pessoa_juridica pessoa_juridica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    
	    String query =  "UPDATE pessoa SET email=?,login=? senha=?, id_cliente=? "
	            + "WHERE id_cliente=?";
	    
	    con.transacao();
	    con.preparar(query);
	    try
	    {
		      con.getPstmt().setString(1, pessoa_juridica.getEmail());
		      con.getPstmt().setString(2, pessoa_juridica.getLogin());
		      con.getPstmt().setString(3, pessoa_juridica.getSenha());
		      con.getPstmt().setInt(4, pessoa_juridica.getId_cliente());
	          res = con.executeUpdate();
	      if (res = con.executeUpdate())
	      {
	        query = "UPDATE pessoa_juridica SET nome_empresa=?, cpnj=? WHERE id_cliente=?";
	        con.preparar(query);
	        con.getPstmt().setString(1, pessoa_juridica.getNome_empresa());
		      con.getPstmt().setInt(2, pessoa_juridica.getCnpj());
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
	    String query = "SELECT cnjp, nome_empresa FROM pessoa_juridica ORDER BY cnpj";

	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        pessoa_juridica juridica = new pessoa_juridica();
	        juridica.setCnpj(rs.getInt("cnpj"));
	        juridica.setNome_empresa(rs.getString("nome_empresa"));
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
