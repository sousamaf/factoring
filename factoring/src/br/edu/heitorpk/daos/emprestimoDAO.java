package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.heitorpk.classes.emprestimo;
import br.edu.heitorpk.conexao.Conexao;

public class emprestimoDAO {
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
		public boolean atualizar(emprestimo emprestimo)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE movimentacao, pessoa SET  id_movimentacao=?, id_cliente "
		            + "WHERE id_movimentacao=?, id_cleinte";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
			      con.getPstmt().setInt(1, emprestimo.getId_movimentacao().getId_movimentacao());
			      con.getPstmt().setInt(2, emprestimo.getId_cliente().getId_cliente());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE emprestimo SET comprovante_de_renda=?,vale_emprestimo=? juros_mensal=?, juros_atraso=?"
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
		    String query = "SELECT emprestimo, id_emprestimo FROM id_emprestimo ORDER BY id_emprestimo";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        emprestimo emp = new emprestimo();
		        emp.setId_emprestimo(rs.getInt("id_emprestimo"));
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
		
		
}
