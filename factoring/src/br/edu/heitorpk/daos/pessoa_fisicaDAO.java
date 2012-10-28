package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.heitorpk.classes.pessoa_fisica;
import br.edu.heitorpk.conexao.Conexao;

public class pessoa_fisicaDAO {
	
	@SuppressWarnings("finally")
	public boolean excluir(pessoa_fisica pessoa_fisica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM pessoa_fisica WHERE id_cliente=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, pessoa_fisica.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM pessoa_fisica WHERE id_cliente=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, pessoa_fisica.getId_cliente());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

	  @SuppressWarnings("finally")
	public boolean inserir(pessoa_fisica pessoa_fisica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    int idfisica = 0;
	    String query ="INSERT INTO pessoa_fisica (nome, cpf, rg, sexo, data_de_nascimento)" 
	    		+"INSERT INTO pessoa (email,login, senha) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    con.transacao();
	    con.preparar(query, 0);
	    try
	    {
	      con.getPstmt().setString(1, pessoa_fisica.getNome());
	      con.getPstmt().setInt(2, pessoa_fisica.getCpf());
	      con.getPstmt().setInt(3, pessoa_fisica.getRg());
	      con.getPstmt().setString(4, pessoa_fisica.getSexo());
	      con.getPstmt().setLong(5, pessoa_fisica.getData_de_nascimento().getTimeInMillis());
	      con.getPstmt().setString(6, pessoa_fisica.getEmail());
	      con.getPstmt().setString(7, pessoa_fisica.getLogin());
	      con.getPstmt().setString(8, pessoa_fisica.getSenha());
	      con.getPstmt().setInt(9, pessoa_fisica.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	        ResultSet rs = con.getPstmt().getGeneratedKeys();
	        if (rs.next())
	        {
	          idfisica = rs.getInt(1);
	          query = "INSERT INTO pessoa_fisica (nome, cpf, rg, sexo, data_de_nascimento)" 
	  	    		+"INSERT INTO pessoa (email,login, senha) "
		            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	          con.preparar(query);
	          con.getPstmt().setInt(1, idfisica);
	          con.getPstmt().setString(1, pessoa_fisica.getNome());
		      con.getPstmt().setInt(2, pessoa_fisica.getCpf());
		      con.getPstmt().setInt(3, pessoa_fisica.getRg());
		      con.getPstmt().setString(4, pessoa_fisica.getSexo());
		      con.getPstmt().setLong(5, pessoa_fisica.getData_de_nascimento().getTimeInMillis());
		      con.getPstmt().setString(6, pessoa_fisica.getEmail());
		      con.getPstmt().setString(7, pessoa_fisica.getLogin());
		      con.getPstmt().setString(8, pessoa_fisica.getSenha());
		      con.getPstmt().setInt(9, pessoa_fisica.getId_cliente());
	          res = con.executeUpdate();
	        }
	        else
	        {
	          res = false;
	        }
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

	  @SuppressWarnings("finally")
	public boolean atualizar(pessoa_fisica pessoa_fisica)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    
	    String query = "UPDATE pessoa_fisica SET nome=?, cep=?, rg=?, sexo=? data_de_nascimento=?" 
	    + "UPDATE pessoa SET email=?,login=? senha=?, id_cliente=? "
	            + "WHERE pessoa_id_cliente=?";
	    
	    con.transacao();
	    con.preparar(query);
	    try
	    {
	    	  con.getPstmt().setString(1, pessoa_fisica.getNome());
		      con.getPstmt().setInt(2, pessoa_fisica.getCpf());
		      con.getPstmt().setInt(3, pessoa_fisica.getRg());
		      con.getPstmt().setString(4, pessoa_fisica.getSexo());
		      con.getPstmt().setLong(5, pessoa_fisica.getData_de_nascimento().getTimeInMillis());
		      con.getPstmt().setString(6, pessoa_fisica.getEmail());
		      con.getPstmt().setString(7, pessoa_fisica.getLogin());
		      con.getPstmt().setString(8, pessoa_fisica.getSenha());
		      con.getPstmt().setInt(9, pessoa_fisica.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	        query = "UPDATE pessoa_fisica SET nome?, cpf=?, rg=?, sexo=?, data_de_nascimento=? WHERE id_cliente=?";
	        con.preparar(query);
	          con.getPstmt().setString(1, pessoa_fisica.getNome());
		      con.getPstmt().setInt(2, pessoa_fisica.getCpf());
		      con.getPstmt().setInt(3, pessoa_fisica.getRg());
		      con.getPstmt().setString(4, pessoa_fisica.getSexo());
		      con.getPstmt().setLong(5, pessoa_fisica.getData_de_nascimento().getTimeInMillis());
		      con.getPstmt().setString(6, pessoa_fisica.getEmail());
		      con.getPstmt().setString(7, pessoa_fisica.getLogin());
		      con.getPstmt().setString(8, pessoa_fisica.getSenha());
		      con.getPstmt().setInt(9, pessoa_fisica.getId_cliente());
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
	public ArrayList<pessoa_fisica> buscar()
	  {
	    ArrayList<pessoa_fisica> res = new ArrayList<pessoa_fisica>();
	    Conexao con = new Conexao();
	    String query = "SELECT pessoa_fisica, cpf FROM uf ORDER BY cpf";

	    con.preparar(query);
	    try
	    {
	      ResultSet rs = con.getPstmt().executeQuery();
	      while (rs.next())
	      {
	        pessoa_fisica fisica = new pessoa_fisica();
	        fisica.setCpf(rs.getInt("cpf"));
	        res.add(fisica);
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechar();
	      return (res);
	    }
	  }

	  @SuppressWarnings("finally")
	public pessoa_fisica buscar(String pessoa_fisica)
	  {
	    pessoa_fisica res = null;
	    Conexao con = new Conexao();
	    String query = "SELECT pessoa_fisica, rg FROM rg WHERE pessoa_fisica=?";

	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setString(1, pessoa_fisica);
	      ResultSet rs = con.getPstmt().executeQuery();
	      if (rs.next())
	      {
	        res = new pessoa_fisica();
	        res.setRg(rs.getInt("rg"));
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(pessoa_fisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechar();
	      return (res);
	    }
	  }
}
