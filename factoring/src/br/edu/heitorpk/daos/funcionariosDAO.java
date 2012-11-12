package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.classes.funcionarios;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.classes.pessoa_fisica;
import br.edu.heitorpk.conexao.Conexao;

public class funcionariosDAO implements Serializable{
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
	    	 
	          query = "DELETE FROM pessoa WHERE id_cliente=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, funcionario.getId_cliente());
	          res = con.executeUpdate();
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
		public boolean inserir(funcionarios fun)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO funcionarios (gerente, salario, data_entrada, data_saida) "
		            + "VALUES (?, ?, ?, ? )";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setBoolean(1, fun.isGerente());
		      con.getPstmt().setFloat(2, fun.getSalario());
		      con.getPstmt().setLong(3, fun.getData_de_entrada().getTimeInMillis());
		      con.getPstmt().setLong(4, fun.getData_de_saida().getTimeInMillis());
		      con.getPstmt().setInt(5, fun.getId_caixa().getId_caixa());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(funcionariosDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(pessoa p, pessoa_fisica fisica, funcionarios fun)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "" +
		    		"UPDATE f.nome, f.cpf, f.rg, f.sexo, f.data_de_nascimento, p.email, p.login, p.senha, p.id_cliente" +
		    		"FROM pessoa_fisica.f, pessoa.p" +
		    		"WHERE f.pessoa_fisica,p.id_cliente";
		    
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
		        query = "UPDATE funcionarios SET gerente=? salario=?, data_de_entrada=?, data_de_saida=? "
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
		    String query = "SELECT cpf,nome, rg, sexo, data_de_nascimento FROM pessoa_fisica ORDER BY cpf";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        pessoa_fisica p = new pessoa_fisica();
		        p.setCpf(rs.getInt("cpf"));
		        p.setNome(rs.getString("nome"));
		        p.setRg(rs.getInt("rg"));
		        p.setSexo(rs.getString("sexo"));
		        Date t = rs.getDate("data_de_nascimento");
		        Calendar cal =  Calendar.getInstance();
		        cal.setTime(t);
		        p.setData_de_nascimento(cal);
		        
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
		    String query = "SELECT id_funcionario, gerente, salario, data_entrada, data_saida, id_caixa FROM funcionarios ";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        funcionarios f = new funcionarios();
		        f.setId_funcionario(rs.getInt("id_funcionario"));
		        f.setGerente(rs.getBoolean("gerente"));
		        f.setSalario(rs.getFloat("salario"));
		        Date t = rs.getDate("data_de_entrada");
		        Calendar cal =  Calendar.getInstance();
		        cal.setTime(t);
		        f.setData_de_entrada(cal);
		        
		        t = rs.getDate("data_de_saida");
		         cal =  Calendar.getInstance();
		        cal.setTime(t);
		        f.setData_de_entrada(cal);
		        f.setId_caixa(rs.getInt("id_caixa"));
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
