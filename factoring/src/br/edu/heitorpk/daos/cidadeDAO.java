package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.cidade;
import br.edu.heitorpk.classes.estado;
import br.edu.heitorpk.conexao.Conexao;

public class cidadeDAO {
	@SuppressWarnings("finally")
	public boolean excluir(cidade id_cidade)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM id_cidade WHERE id_cidade=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id_cidade.getId_cidade());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public boolean inserir(cidade cidade)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "INSERT INTO cidade (nome, id_cidade) "
	            + "VALUES (?, ?)";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, cidade.getNome());
	      con.getPstmt().setString(2, cidade.getId_uf().getId_uf());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public boolean atualizar(cidade cidade)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "UPDATE cidade SET nome=?, id_uf=? "
	            + "WHERE idcidade=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, cidade.getNome());
	      con.getPstmt().setString(2, cidade.getId_uf().getId_uf());
	      con.getPstmt().setInt(3, cidade.getId_cidade());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public ArrayList<cidade> buscar()
	  {
	    ArrayList<cidade> res = new ArrayList<cidade>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_cidade, nome, id_uf "
	            + "FROM cidade ORDER BY nome";
	    
	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        cidade cidade = new cidade();
	        cidade.setId_cidade(rs.getInt("id_cidade"));
	        cidade.setNome(rs.getString("nome"));
	        
	        estadoDAO ufdao = new estadoDAO();
	        estado id_uf = ufdao.buscar(rs.getString("id_uf"));
	        
	        cidade.setId_uf(id_uf);
	        res.add(cidade);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public ArrayList<cidade> buscar(estado id_uf)
	  {
	    ArrayList<cidade> res = new ArrayList<cidade>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_cidade, nome, id_uf "
	            + "FROM cidade WHERE id_uf=? ORDER BY nome";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, id_uf.getId_uf());
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        cidade cidade = new cidade();
	        cidade.setId_cidade(rs.getInt("id_cidade"));
	        cidade.setNome(rs.getString("nome"));
	        cidade.setId_uf(id_uf);
	        res.add(cidade);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public ArrayList<cidade> buscar(String id_uf)
	  {
	    ArrayList<cidade> res = new ArrayList<cidade>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_cidade, nome, id_uf "
	            + "FROM cidade WHERE id_uf=? ORDER BY nome";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, id_uf);
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        cidade cidade = new cidade();
	        cidade.setId_cidade(rs.getInt("id_cidade"));
	        cidade.setNome(rs.getString("nome"));
	        
	        estadoDAO ufdao = new estadoDAO();
	        estado u = ufdao.buscar(id_uf);
	        cidade.setId_uf(u);
	        res.add(cidade);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public cidade buscar(int id_cidade)
	  {
	    cidade res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT id_cidade, nome, id_uf "
	            + "FROM cidade WHERE id_cidade=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id_cidade);
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new cidade();
	        res.setId_cidade(rs.getInt("id_cidade"));
	        res.setNome(rs.getString("nome"));
	        
	        estadoDAO ufdao = new estadoDAO();
	        estado u = ufdao.buscar(rs.getString("id_uf"));
	        
	        res.setId_uf(u);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public cidade buscarPorNome(String nome)
	  {
	    cidade res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT id_cidade, nome, id_uf "
	            + "FROM cidade WHERE nome LIKE ?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, "%"+nome+"%");
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new cidade();
	        res.setId_cidade(rs.getInt("id_cidade"));
	        res.setNome(rs.getString("nome"));
	        
	        estadoDAO ufdao = new estadoDAO();
	        estado u = ufdao.buscar(rs.getString("uf"));
	        
	        res.setId_uf(u);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(cidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
}
