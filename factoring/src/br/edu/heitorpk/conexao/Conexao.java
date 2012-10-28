package br.edu.heitorpk.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao
{

  private Connection connection = null;
  private PreparedStatement pstmt = null;

  public Conexao()
  {
    try
    {
      String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
      Class.forName(driverName).newInstance();
      String serverName = "localhost:3306";
      String mydatabase = "bd120122";
      String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a URL JDBC
      String username = "root";
      String password = "heitor";
      this.connection = java.sql.DriverManager.getConnection(url, username, password);
    } catch (InstantiationException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException e)
    {
      System.out.println("Nao foi possivel encontrar o driver: " + e.toString());
    } catch (java.sql.SQLException e)
    {
      System.out.println("Nao foi possivel conectar ao banco de dados: " + e.toString());
    }
  }

  public void fechar()
  {
    try
    {
      this.connection.setAutoCommit(true);
      this.connection.close();
      this.pstmt.close();
    } catch (SQLException ex)
    {
      System.err.println(Conexao.class.getName() + " " + ex.toString());
    }
  }
  
  public void transacao()
  {
    try
    {
      this.connection.setAutoCommit(false);
    } catch (SQLException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void commit()
  {
    try
    {
      this.connection.commit();
    } catch (SQLException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void rollback()
  {
    try
    {
      this.connection.rollback();
    } catch (SQLException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void fechaTransacao(boolean b)
  {
    if (b)
    {
      this.commit();
    }
    else
    {
      this.rollback();
    }
  }
  
/*
 * Prepara uma SQL para ser executada
 */
  public void preparar(String query)
  {
    try
    {
      this.pstmt = this.connection.prepareStatement(query);
    } catch (SQLException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void preparar(String query, int key)
  {
    try
    {
      this.pstmt = this.connection.prepareStatement(query, this.pstmt.RETURN_GENERATED_KEYS);
    } catch (SQLException ex)
    {
      Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public ResultSet executeQuery() throws SQLException
  {
    return(this.pstmt.executeQuery());
  }

  public boolean executeUpdate() throws SQLException
  {
    return(this.pstmt.executeUpdate() > 0 ? true : false);
  }

  public PreparedStatement getPstmt()
  {
    return pstmt;
  }
}