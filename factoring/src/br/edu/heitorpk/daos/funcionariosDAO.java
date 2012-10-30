package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.heitorpk.classes.funcionarios;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.classes.pessoa_fisica;
import br.edu.heitorpk.conexao.Conexao;

public class funcionariosDAO {
	@SuppressWarnings("finally")
	  public boolean excluir(funcionarios funcionario)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM funcionarios WHERE id_pessoa=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, funcionario.getId_cliente());
	      if (res = con.executeUpdate())
	      {
	    	  pessoaDAO aDAO = new pessoaDAO();
	    	  if(aDAO.buscar(pessoa.getid_cliente())==null){
	    	  
	          query = "DELETE FROM pessoa WHERE id_cliente=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, funcionario.getId_cliente());
	          res = con.executeUpdate();
	    	  }
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(funcionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

		@SuppressWarnings("finally")
		public boolean atualizar(pessoa p, pessoa_fisica fisica, funcionarios fun)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE pessoa_fisica, pessoa SET email=?,login=? senha=?, id_cliente=?," +
		    		" nome=?, cpf=?, rg=?, sexo=?, data_de_nascimento=?"
		            + "WHERE id_pessoa_fisica=?, id_cliente=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, p.getEmail());
			      con.getPstmt().setString(2, p.getLogin());
			      con.getPstmt().setString(3, p.getSenha());
			      con.getPstmt().setString(4, fisica.getNome());
			      con.getPstmt().setInt(5, fisica.getCpf());
			      con.getPstmt().setInt(6, fisica.getRg());
			      con.getPstmt().setString(7, fisica.getSexo());
			      con.getPstmt().setLong(8, fisica.getData_de_nascimento().getTimeInMillis());
			      con.getPstmt().setInt(9, fun.getId_cliente());
			      
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE funcionarios SET gerente=? salario=?, data_de_entrada=?, data_de_saida=?"
			            + "WHERE id_funcionario=?";
		        con.preparar(query);
			      con.getPstmt().setFloat(1, fun.getSalario());
			      con.getPstmt().setLong(2, fun.getData_de_entrada().getTimeInMillis());
			      con.getPstmt().setLong(3, fun.getData_de_saida().getTimeInMillis());
			      con.getPstmt().setBoolean(4, fun.isGerente());
			      con.getPstmt().setInt(5, fun.getId_funcionario());
			      
		          res = con.executeUpdate();
		        res = con.executeUpdate();
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(funcionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		    String query = "SELECT pessoa_fisica, cpf FROM cpf ORDER BY cpf";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        pessoa_fisica p = new pessoa_fisica();
		        p.setCpf(rs.getInt("cpf"));
		        res.add(p);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(funcionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
		@SuppressWarnings("finally")
		public ArrayList<funcionarios> buscarid()
		  {
		    ArrayList<funcionarios> res = new ArrayList<funcionarios>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_funcionario FROM id_funcionario ORDER BY id_funcionario";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        funcionarios f = new funcionarios();
		        f.setId_funcionario(rs.getInt("id_funcionario"));
		        res.add(f);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(funcionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
}
