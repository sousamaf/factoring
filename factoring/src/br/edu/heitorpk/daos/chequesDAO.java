package br.edu.heitorpk.daos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.heitorpk.beans.cheques;
import br.edu.heitorpk.beans.cidade;
import br.edu.heitorpk.conexao.Conexao;

public class chequesDAO implements Serializable{
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
		public boolean inserir(cheques cheq)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    String query = "INSERT INTO cheques (titular,banco, agencia, numero_conta, numero,cpf_cnpj, telefone, valor, recebimento, vencimento" +
		    		"pessoa_id_cliente, movimentacao_id_movimentacao, tipo_cheque_id_tipo ) "
		            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    
		    con.preparar(query);
		    try
		    {
		      con.getPstmt().setString(1, cheq.getTitular());
		      con.getPstmt().setInt(2, cheq.getBanco());
		      con.getPstmt().setInt(3, cheq.getAgencia());
		      con.getPstmt().setInt(4, cheq.getNumero_conta());
		      con.getPstmt().setInt(5, cheq.getNumero());
		      con.getPstmt().setInt(6, cheq.getCpf_cnpj());
		      con.getPstmt().setInt(7, cheq.getTelefone());
		      con.getPstmt().setFloat(8, cheq.getValor());
		      con.getPstmt().setLong(9, cheq.getRecebimento().getTimeInMillis());
		      con.getPstmt().setLong(10, cheq.getVencimento().getTimeInMillis());
		      con.getPstmt().setInt(11, cheq.getId_cliente().getId_cliente());
		      con.getPstmt().setInt(12, cheq.getId_movimentacao().getId_movimentacao());
		      con.getPstmt().setInt(13, cheq.getId_tipo().getId_tipo());
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
		public boolean atualizar(cheques cheq)
		  {
		    boolean res = false;
		    Conexao con = new Conexao();
		    
		    String query =  "UPDADTE p.pessoa_id_cliente=?, m.movimentacao_id_movimentacao=?, t.tipo_cheque_id_tipo=?" +
		    		"FROM pessoa.p, movimentacao.m, tipo_cheque.t " +
		    		"WHERE p.pessoa_id_cliente=?, m.movimentacao_id_movimentacao=?, t.tipo_cheque_id_tipo=?";
		    
		    con.transacao();
		    con.preparar(query);
		    try
		    {
			      con.getPstmt().setInt(1, cheq.getId_cliente().getId_cliente());
			      con.getPstmt().setInt(2, cheq.getId_tipo().getId_tipo());
			      con.getPstmt().setInt(3, cheq.getId_movimentacao().getId_movimentacao());
		          res = con.executeUpdate();
		          
		      if (res = con.executeUpdate())
		      {
		        query = "UPDATE cheques SET titular=?,banco=? agencia=?, numero_conta=? numero=?,cpf_cnpj=? telefone=? "
			    		+ "valor=?, recebimento=? vencimento=?"
			            + "WHERE id_cheque=?";
		        con.preparar(query);
		        con.getPstmt().setString(1, cheq.getTitular());
			      con.getPstmt().setInt(2, cheq.getBanco());
			      con.getPstmt().setInt(3, cheq.getAgencia());
			      con.getPstmt().setInt(4, cheq.getNumero_conta());
			      con.getPstmt().setInt(5, cheq.getNumero());
			      con.getPstmt().setInt(6, cheq.getCpf_cnpj());
			      con.getPstmt().setInt(7, cheq.getTelefone());
			      con.getPstmt().setFloat(8, cheq.getValor());
			      con.getPstmt().setLong(9, cheq.getRecebimento().getTimeInMillis());
			      con.getPstmt().setLong(10, cheq.getVencimento().getTimeInMillis());
			      con.getPstmt().setInt(11, cheq.getId_cheque());
			      
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
		    String query = "SELECT id_cheque, titular, banco, agencia, numero_conta, numero, cpf_cnpj, telefone, valor, recebimento, vencimento "
			    		+"FROM cheques";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        cheques cheq = new cheques();
		        cheq.setId_cheque(rs.getInt("id_cheque"));
		        cheq.setTitular(rs.getString("titular"));
		        cheq.setBanco(rs.getInt("banco"));
		        cheq.setAgencia(rs.getInt("agencia"));
		        cheq.setNumero_conta(rs.getInt("numero_conta"));
		        cheq.setNumero(rs.getInt("numero"));
		        cheq.setCpf_cnpj(rs.getInt("cpf_cnpj"));
		        cheq.setTelefone(rs.getInt("telefone"));
		        cheq.setValor(rs.getFloat("valor"));
		        Date t = rs.getDate("recebimento");
		        Calendar cal =  Calendar.getInstance();
		        cal.setTime(t);
		        cheq.setRecebimento(cal);
		        
		        t = rs.getDate("vencimento");
		        cal =  Calendar.getInstance();
		        cal.setTime(t);
		        cheq.setVencimento(cal);
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
		    String query = "SELECT titular, banco, agencia, numero_conta, numero, cpf_cnpj, telefone, valor, recebimento, vencimento "
		    		+"FROM cheques ORDER BY numero";

		    con.preparar(query);
		    try
		    {
		      ResultSet rs = con.getPstmt().executeQuery();
		      while (rs.next())
		      {
		        cheques cheq = new cheques();
		        cheq.setNumero(rs.getInt("numero"));
		        cheq.setId_cheque(rs.getInt("id_cheque"));
		        cheq.setTitular(rs.getString("titular"));
		        cheq.setBanco(rs.getInt("banco"));
		        cheq.setAgencia(rs.getInt("agencia"));
		        cheq.setNumero_conta(rs.getInt("numero_conta"));
		        cheq.setCpf_cnpj(rs.getInt("cpf_cnpj"));
		        cheq.setTelefone(rs.getInt("telefone"));
		        cheq.setValor(rs.getFloat("valor"));
		        Date t = rs.getDate("recebimento");
		        Calendar cal =  Calendar.getInstance();
		        cal.setTime(t);
		        cheq.setRecebimento(cal);
		        
		        t = rs.getDate("vencimento");
		        cal =  Calendar.getInstance();
		        cal.setTime(t);
		        cheq.setVencimento(cal);
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
