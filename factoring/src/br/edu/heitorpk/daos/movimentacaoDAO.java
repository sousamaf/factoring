package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.heitorpk.classes.movimentacao;
import br.edu.heitorpk.conexao.Conexao;

public class movimentacaoDAO implements Serializable{
	@SuppressWarnings("finally")
	  public boolean excluir(movimentacao id)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM movimentacao WHERE id_movimentacao=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, id.getId_movimentacao());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM movimentacao WHERE id_movimentacao=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, id.getId_movimentacao());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(movimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

		@SuppressWarnings("finally")
		public boolean atualizar(movimentacao mov)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE movimentacao SET valor_movimentacao=?,hora_movimentacao=?, id_caixa  "
		            + "WHERE id_movimentacao=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setFloat(1, mov.getValor_movimentacao());
			      con.getPstmt().setLong(2, mov.getHora_movimentacao().getTimeInMillis());
			      con.getPstmt().setInt(3, mov.getId_caixa().getId_caixa());
		          res = con.executeUpdate();
		     
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(movimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    finally
		    {
		      con.fechaTransacao(res);
		      con.fechar();
		      return(res);
		    }
		  }

		  @SuppressWarnings("finally")
		public ArrayList<movimentacao> buscar()
		  {
		    ArrayList<movimentacao> res = new ArrayList<movimentacao>();
		    Conexao con = new Conexao();
		    String query = "SELECT id_movimentacao, valor_movimentacao, hora_movimentacao, id_caixa FROM movimentacao";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        movimentacao mov = new movimentacao();
		        mov.setId_movimentacao(rs.getInt("id_movimentacao"));
		        mov.setValor_movimentacao(rs.getFloat("valor_movimentacao"));
		        Date t = rs.getDate("hora_movimentacao");
		        Calendar cal =  Calendar.getInstance();
		        cal.setTime(t);
		        mov.setHora_movimentacao(cal);
		        //mov.setId_caixa(rs.getInt("id_caixa"));
		        res.add(mov);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(movimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		 @SuppressWarnings("finally")
			public ArrayList<movimentacao> buscarValorMovimentacao()
			  {
			    ArrayList<movimentacao> res = new ArrayList<movimentacao>();
			    Conexao con = new Conexao();
			    String query = "SELECT id_movimentacao, valor_movimentacao, hora_movimentacao, id_caixa FROM movimentacao ORDER BY valor_movimentacao";

			    con.preparar(query);
			    try
			    {
			      ResultSet rs = con.getPstmt().executeQuery();
			      while (rs.next())
			      {
			        movimentacao mov = new movimentacao();
			        mov.setId_movimentacao(rs.getInt("id_movimentacao"));
			        mov.setValor_movimentacao(rs.getFloat("valor_movimentacao"));
			        Date t = rs.getDate("hora_movimentacao");
			        Calendar cal =  Calendar.getInstance();
			        cal.setTime(t);
			        mov.setHora_movimentacao(cal);
			        //mov.setId_caixa(rs.getInt("id_caixa"));
			        res.add(mov);
			      }
			    } catch (SQLException ex)
			    {
			      Logger.getLogger(movimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
			    } finally
			    {
			      con.fechar();
			      return (res);
			    }
			  }
}
