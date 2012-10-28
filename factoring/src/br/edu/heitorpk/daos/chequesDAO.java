package br.edu.heitorpk.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.classes.cheques;
import br.edu.heitorpk.conexao.Conexao;

public class chequesDAO {
	@SuppressWarnings("finally")
	  public boolean excluir(cheques cheq)
	  {
	    boolean res = false;
	    Conexao con = new Conexao();
	    String query = "DELETE FROM cheques WHERE id_cheque=?";

	    con.transacao();
	    con.preparar(query);
	    try
	    {
	      con.getPstmt().setInt(1, cheq.getId_cheque());
	      if (res = con.executeUpdate())
	      {
	       
	          query = "DELETE FROM cheques WHERE id_cheque=?";
	          con.preparar(query);
	          con.getPstmt().setInt(1, cheq.getId_cheque());
	          res = con.executeUpdate();
	        
	      }
	    } catch (SQLException ex)
	    {
	      Logger.getLogger(chequesDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally
	    {
	      con.fechaTransacao(res);
	      con.fechar();
	      return (res);
	    }
	  }

		@SuppressWarnings("finally")
		public boolean atualizar(cheques cheq)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDATE cheques SET titular=?,banco=? agencia=?, numero_conta=? numero=?,cpf/cnpj=? telefone=? "
		    		+ "valor=?, recebimento=? vencimento=?"
		            + "WHERE id_cheque=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
		    	  con.getPstmt().setString(1, cheq.getTitular());
			      con.getPstmt().setInt(2, cheq.getBanco());
			      con.getPstmt().setInt(3, cheq.getAgencia());
			      con.getPstmt().setInt(4, cheq.getNumero_conta());
			      con.getPstmt().setInt(5, cheq.getNumero());
			      con.getPstmt().setInt(6, cheq.getCpnf_cnpj());
			      con.getPstmt().setInt(7, cheq.getTelefone());
			      con.getPstmt().setFloat(8, cheq.getValor());
			      con.getPstmt().setLong(9, cheq.getRecebimento().getTimeInMillis());
			      con.getPstmt().setLong(10, cheq.getVencimento().getTimeInMillis());
		          res = con.executeUpdate();
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE cheques SET titular=?,banco=? agencia=?, numero_conta=? numero=?,cpf/cnpj=? telefone=? "
			    		+ "valor=?, recebimento=? vencimento=?"
			            + "WHERE id_cheque=?";
		        con.preparar(query);
		          con.getPstmt().setString(1, cheq.getTitular());
			      con.getPstmt().setInt(2, cheq.getBanco());
			      con.getPstmt().setInt(3, cheq.getAgencia());
			      con.getPstmt().setInt(4, cheq.getNumero_conta());
			      con.getPstmt().setInt(5, cheq.getNumero());
			      con.getPstmt().setInt(6, cheq.getCpnf_cnpj());
			      con.getPstmt().setInt(7, cheq.getTelefone());
			      con.getPstmt().setFloat(8, cheq.getValor());
			      con.getPstmt().setLong(9, cheq.getRecebimento().getTimeInMillis());
			      con.getPstmt().setLong(10, cheq.getVencimento().getTimeInMillis());
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
		public ArrayList<cheques> buscar()
		  {
		    ArrayList<cheques> res = new ArrayList<cheques>();
		    Conexao con = new Conexao();
		    String query = "SELECT cheques, id_cheque FROM uf ORDER BY id_cheque";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        cheques cheq = new cheques();
		        cheq.setId_cheque(rs.getInt("id_cheque"));
		        res.add(cheq);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(chequesDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
		@SuppressWarnings("finally")
		public ArrayList<cheques> buscarPeloNumero()
		  {
		    ArrayList<cheques> res = new ArrayList<cheques>();
		    Conexao con = new Conexao();
		    String query = "SELECT cheques, numero FROM uf ORDER BY numero";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        cheques cheq = new cheques();
		        cheq.setNumero(rs.getInt("numero"));
		        res.add(cheq);
		      }
		    } catch (SQLException ex)
		    {
		      Logger.getLogger(chequesDAO.class.getName()).log(Level.SEVERE, null, ex);
		    } finally
		    {
		      con.fechar();
		      return (res);
		    }
		  }
		
}
