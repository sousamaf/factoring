package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.estado;
import br.edu.heitorpk.conexao.Conexao;

public class estadoDAO {

	@SuppressWarnings("finally")
	public boolean excluir(estado id_uf)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM id_uf  WHERE id_uf=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, id_uf.getId_uf());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public boolean inserir(estado id_uf)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "INSERT INTO id_uf (id_uf, nome) VALUES (?, ?)";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, id_uf.getId_uf());
	      con.getPstmt().setString(2, id_uf.getNome());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public boolean atualizar(estado ufatual, estado ufnova)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "UPDATE id_uf SET id_uf=?, nome=? WHERE id_uf=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, ufnova.getId_uf());
	      con.getPstmt().setString(2, ufnova.getNome());
	      con.getPstmt().setString(3, ufatual.getId_uf());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public ArrayList<estado> buscar()
	  {
	    ArrayList<estado> res = new ArrayList<estado>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_uf, estado FROM uf ORDER BY id_uf";
	    
	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        estado id_uf = new estado();
	        id_uf.setId_uf(rs.getString("id_uf"));
	        id_uf.setNome(rs.getString("nome"));
	        res.add(id_uf);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public estado buscar(String uf)
	  {
	    estado res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT id_uf, nome FROM uf WHERE id_uf=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, uf);
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new estado();
	        res.setId_uf(rs.getString("id_uf"));
	        res.setNome(rs.getString("nome"));
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public estado buscarPorEstado(String estado)
	  {
	    estado res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT id_uf, nome FROM uf WHERE nome LIKE ?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, "%"+estado+"%");
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new estado();
	        res.setId_uf(rs.getString("id_uf"));
	        res.setNome(rs.getString("nome"));
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
}
