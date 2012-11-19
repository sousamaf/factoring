package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.controle_de_caixa;
import br.edu.heitorpk.classes.emprestimo;
import br.edu.heitorpk.classes.movimentacao;
import br.edu.heitorpk.classes.pessoa;
import br.edu.heitorpk.conexao.Conexao;

public class emprestimoDAO implements Serializable{
	 @SuppressWarnings("finally")
	  public boolean excluir(emprestimo emprestimo)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM emprestimo WHERE id_emprestimo=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, emprestimo.getId_emprestimo());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM emprestimo WHERE id_emprestimo=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, emprestimo.getId_emprestimo());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(emprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }
	 @SuppressWarnings("finally")
		public boolean inserir(emprestimo emp)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO emprestimo (comprovante_de_renda, valor_emprestimo, juros_mensal, juros_atraso, id_movimentacao, id_cliente) "
		            + "VALUES (?, ?, ?, ?, ?, ?)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setFloat(1, emp.getComprovante_de_renda());
		      con.getPstmt().setFloat(2, emp.getValor_emprestimo());
		      con.getPstmt().setFloat(3, emp.getJuros_mensal());
		      con.getPstmt().setFloat(4, emp.getJuros_atraso());
		      con.getPstmt().setInt(5, emp.getId_movimentacao().getId_movimentacao());
		      con.getPstmt().setInt(6, emp.getId_cliente().getId_cliente());
		      
		      res = con.executeUpdate();
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(emprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechar();
		      return(res);
		    }
		  }
		@SuppressWarnings("finally")
		public boolean atualizar(emprestimo emprestimo)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query =  "UPDATE m.id_movimentacao, p.id_cliente" +
		    		"FROM movimentacao.m, pessoa.p" +
		    		"WHERE m.id_movimentacao,p.id_cliente";
		    		
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
			      con.getPstmt().setInt(1, emprestimo.getId_movimentacao().getId_movimentacao());
			      con.getPstmt().setInt(2, emprestimo.getId_cliente().getId_cliente());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE emprestimo SET comprovante_de_renda=?,valor_emprestimo=?, juros_mensal=?, juros_atraso=? "
			            + "WHERE id_emprestimo=?";
		        con.preparar(query);
		        con.getPstmt().setFloat(1, emprestimo.getComprovante_de_renda());
			      con.getPstmt().setFloat(2, emprestimo.getValor_emprestimo());
			      con.getPstmt().setFloat(3, emprestimo.getJuros_atraso());
			      con.getPstmt().setFloat(4, emprestimo.getJuros_mensal());
			      con.getPstmt().setInt(5, emprestimo.getId_emprestimo());
			      
		          res = con.executeUpdate();
		        res = con.executeUpdate();
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(emprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<emprestimo> buscar()
		  {
		    ArrayList<emprestimo> res = new ArrayList<emprestimo>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_emprestimo, comprovante_de_renda,valor_emprestimo, juros_mensal, juros_atraso"
			            + "FROM emprestimo WHERE id_emprestimo=? ";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        emprestimo emp = new emprestimo();
		        emp.setId_emprestimo(rs.getInt("id_emprestimo"));
		        emp.setComprovante_de_renda(rs.getFloat("comprovante_de_renda"));
		        emp.setValor_emprestimo(rs.getFloat("valor_emprestimo"));
		        emp.setJuros_mensal(rs.getFloat("juros_mensal"));
		        emp.setJuros_atraso(rs.getFloat("juros_atraso"));
		        res.add(emp);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(emprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		public static void main (String args[]){
			  emprestimo emprestimo = new emprestimo();
			  pessoa pessoa = new pessoa();
			  movimentacao movimentacao = new movimentacao ();
			  
			  emprestimo.set
			  
			 /* estado estado = new estado();
			  cid.setNome("Pium");
			  estado.setId_uf("To");
			  cid.setId_uf(estado);
			  */
			  

			  controle_de_caixaDAO c = new controle_de_caixaDAO();
			  
		  }
		
}
