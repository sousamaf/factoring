package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.cidade;
import br.edu.heitorpk.classes.endereco;
import br.edu.heitorpk.classes.estado;
import br.edu.heitorpk.conexao.Conexao;

public class enderecoDAO {
	@SuppressWarnings("finally")
	public boolean excluir(endereco id_endereco)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM id_endereco WHERE id_endereco=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id_endereco.getId_endereco());
	      res = con.executeUpdate();
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(enderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public boolean inserir(endereco endereco)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "INSERT INTO endereco (id_endereco, cep, quadra, lote, telefone, referencia, id_cidade) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, endereco.getCep());
	      con.getPstmt().setString(2, endereco.getQuadra());
	      con.getPstmt().setInt(3, endereco.getAlameda());
	      con.getPstmt().setInt(4, endereco.getLote());
	      con.getPstmt().setString(5, endereco.getReferencia());
	      con.getPstmt().setInt(6, endereco.getTelefone());
	      con.getPstmt().setInt(7, endereco.getId_cidade().getId_cidade());
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
	public boolean atualizar(endereco endereco)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "UPDATE endereco SET cep=?, , quadra=?, alameda=?, lote=?, referencia=?, telefone=?, id_cidade=? "
	            + "WHERE id_endereco=?";
	    
	    con.preparar(query);
	    try
	    {
	    	con.getPstmt().setInt(1, endereco.getCep());
		      con.getPstmt().setString(2, endereco.getQuadra());
		      con.getPstmt().setInt(3, endereco.getAlameda());
		      con.getPstmt().setInt(4, endereco.getLote());
		      con.getPstmt().setString(5, endereco.getReferencia());
		      con.getPstmt().setInt(6, endereco.getTelefone());
		      con.getPstmt().setInt(7, endereco.getId_cidade().getId_cidade());
		      con.getPstmt().setInt(8, endereco.getId_endereco());
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
	public ArrayList<endereco> buscar()
	  {
	    ArrayList<endereco> res = new ArrayList<endereco>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_endereco, cep, quadra, alameda, lote, referencia, telefone, cidade id_cidade "
	            + "FROM endereco ORDER BY quadra";
	    
	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        endereco endereco = new endereco();
	        endereco.setId_endereco(rs.getInt("id_endereco"));
	        endereco.setCep(rs.getInt("cep"));
	        endereco.setQuadra(rs.getString("quadra"));
	        endereco.setAlameda(rs.getInt("alameda"));
	        endereco.setLote(rs.getInt("lote"));
	        endereco.setReferencia(rs.getString("referencia"));
	        endereco.setTelefone(rs.getInt("telefone"));
	        
	        cidadeDAO cidadedao = new cidadeDAO();
	        cidade id_cidade = cidadedao.buscar(rs.getInt("id_cidade"));
	        
	        endereco.setId_cidade(id_cidade);
	        res.add(endereco);
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
	public ArrayList<endereco> buscar(cidade id_cidade)
	  {
	    ArrayList<endereco> res = new ArrayList<endereco>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_endereco, cep, quadra, alameda, lote, referencia, telefone, cidade id_cidade "
	            + "FROM endereco WHERE id_cidade=?  ORDER BY quadra";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id_cidade.getId_cidade());
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	    	  	endereco endereco = new endereco();
		        endereco.setId_endereco(rs.getInt("id_endereco"));
		        endereco.setCep(rs.getInt("cep"));
		        endereco.setQuadra(rs.getString("quadra"));
		        endereco.setAlameda(rs.getInt("alameda"));
		        endereco.setLote(rs.getInt("lote"));
		        endereco.setReferencia(rs.getString("referencia"));
		        endereco.setTelefone(rs.getInt("telefone"));
		        
		        endereco.setId_cidade(id_cidade);
		        res.add(endereco);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(enderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
	      con.fechar();
	      return(res);
	    }
	  }
	  
	  @SuppressWarnings("finally")
	public ArrayList<endereco> buscar(String id_cidade)
	  {
	    ArrayList<endereco> res = new ArrayList<endereco>();
	    Conexao con = new Conexao();
	    String query = "SELECT id_endereco, cep, quadra, alameda, lote, referencia, telefone, cidade id_cidade "
	            + "FROM endereco WHERE id_cidade=?  ORDER BY quadra";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, id_cidade);
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	    	  endereco endereco = new endereco();
		        endereco.setId_endereco(rs.getInt("id_endereco"));
		        endereco.setCep(rs.getInt("cep"));
		        endereco.setQuadra(rs.getString("quadra"));
		        endereco.setAlameda(rs.getInt("alameda"));
		        endereco.setLote(rs.getInt("lote"));
		        endereco.setReferencia(rs.getString("referencia"));
		        endereco.setTelefone(rs.getInt("telefone"));
		        
		        cidadeDAO cidadedao = new cidadeDAO();
		        cidade id_cidad = cidadedao.buscar(rs.getInt("id_cidade"));
		        
		        endereco.setId_cidade(id_cidad);
		        res.add(endereco);
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
	public endereco buscar(int id_endereco)
	  {
	    endereco res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT id_endereco, cep,quadra, alameda, lote, referencia, telefone, id_cidade "
	            + "FROM endereco WHERE id_endereco=?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id_endereco);
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new endereco();
	        res.setId_endereco(rs.getInt("id_endereco"));
	        res.setCep(rs.getInt("cep"));
	        res.setQuadra(rs.getString("qudra"));
	        res.setAlameda(rs.getInt("alameda"));
	        res.setLote(rs.getInt("lote"));
	        res.setReferencia(rs.getString("referencia"));
	        res.setTelefone(rs.getInt("telefone"));
	        
	        cidadeDAO cidadedao = new cidadeDAO();
	        cidade u = cidadedao.buscar(rs.getInt("id_cidade"));
	        
	        res.setId_cidade(u);
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
	public endereco buscarPorNome(String cep)
	  {
	    endereco res = null;
	    Conexao con = new Conexao();
	    String query ="SELECT id_endereco, cep,quadra, alameda, lote, referencia, telefone, id_cidade "
	            + "FROM endereco WHERE id_endereco=? LIKE ?";
	    
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, "%"+cep+"%");
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	    	  res = new endereco();
		        res.setId_endereco(rs.getInt("id_endereco"));
		        res.setCep(rs.getInt("cep"));
		        res.setQuadra(rs.getString("quadra"));
		        res.setAlameda(rs.getInt("alameda"));
		        res.setLote(rs.getInt("lote"));
		        res.setReferencia(rs.getString("referencia"));
		        res.setTelefone(rs.getInt("telefone"));
		        
		        cidadeDAO cidadedao = new cidadeDAO();
		        cidade u = cidadedao.buscar(rs.getInt("id_cidade"));
		        
		        res.setId_cidade(u);
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
