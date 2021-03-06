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
import br.edu.heitorpk.conexao.Conexao;

public class fiadorDAO implements Serializable{
	/*
	public static void main(String args[]){
		fiador fiador = new fiador();
		pessoa p = new pessoa();
		p.setId_cliente(1);
		fiador.setId_cliente(p);
		//fiador.setId_fiador(3);
		
		fiadorDAO f = new fiadorDAO();
		//f.excluir(fiador);
		f.inserir(fiador);
	}
	*/
	  @SuppressWarnings("finally")
	  public boolean excluir(fiador fiador)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM fiador WHERE id_fiador=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, fiador.getId_fiador());
	      res = con.executeUpdate();
	    
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(fiadorDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }
	  @SuppressWarnings("finally")
		public boolean inserir(fiador fiador)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO fiador (pessoa_id_cliente ) "
		            + "VALUES (?)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setInt(1, fiador.getId_cliente().getId_cliente());
		      
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(fiadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(pessoa fiador)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE pessoa SET email=?,login=?, senha=?, id_cliente=?, id_fiador "
		            + "WHERE id_cliente=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, fiador.getEmail());
			      con.getPstmt().setString(2, fiador.getLogin());
			      con.getPstmt().setString(3, fiador.getSenha());
			      con.getPstmt().setInt(4, fiador.getId_cliente());
		          res = con.executeUpdate();
		     
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(fiadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<pessoa> buscar()
		  {
		    ArrayList<pessoa> res = new ArrayList<pessoa>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_cleinte, email, login, senha  FROM pessoa ORDER BY email";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        pessoa p = new pessoa();
		        p.setId_cliente(rs.getInt("id_cliente"));
		        p.setEmail(rs.getString("email"));
		        p.setLogin(rs.getString("login"));
		        p.setSenha(rs.getString("senha"));
		        res.add(p);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(fiadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
}
