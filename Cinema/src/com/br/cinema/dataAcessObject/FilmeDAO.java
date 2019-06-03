package com.br.cinema.dataAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cinema.connectionFactory.ConnectionFactory;
import com.br.cinema.model.FilmeModel;

public class FilmeDAO {
	
	private FilmeModel objFilme;
	private String sqlString;
	
	public void inserFilme(FilmeModel pObjFilme) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Insert into Filme(nome_filme, ano_producao)"
				  + "Values(?,?)";
		
		try
		{
		PreparedStatement smtp = connection.prepareStatement(sqlString);
		smtp.setString(1, pObjFilme.getNome_filme());
		smtp.setString(2, pObjFilme.getAno_producao());
		smtp.execute();
		smtp.close();
		}
		catch(SQLException ex)
		{
			throw new RuntimeException(ex);
		}
		
		ConnectionFactory.ReleaseConnection(connection);
	}
	public FilmeModel consultaFilme(FilmeModel pObjFilme) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Select * from Filme Where nome_filme=?";
		
		try
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, pObjFilme.getNome_filme());
			ResultSet rs = smtp.executeQuery();
			
			if ( rs != null ){
				objFilme = pObjFilme;
				smtp.close();
				return objFilme;
			}
			else 
			{
				return null;
			}
				
		}
		catch (SQLException ex)
		{
			throw new RuntimeException(ex);
		}
		
	}
	public FilmeModel consultaFilme(Integer idFilme) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Select * from Filme Where idFilme=?";
		
		try
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setInt(1, idFilme);
			ResultSet rs = smtp.executeQuery();
			
			if ( rs != null )
			{
				objFilme.setIdfilme(rs.getInt(0));
				objFilme.setNome_filme(rs.getString(1));
				objFilme.setAno_producao(rs.getString(2));
				smtp.close();
				return objFilme;
			}
			else 
			{
				return null;
			}
		}
		catch (SQLException ex)
		{
			throw new RuntimeException(ex);
		}	
	}
	public void deleteFilme(FilmeModel pObjFilme) throws ClassNotFoundException{
		
		objFilme = consultaFilme(pObjFilme);
		
		if (objFilme != null )
		{
			Connection connection = ConnectionFactory.getConnection();
			sqlString = "Delete from Filme Where nome_filme=?";
			
			try
			{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, pObjFilme.getNome_filme());
			smtp.execute();
			smtp.close();
			}
			catch( SQLException ex)
			{
				throw new RuntimeException(ex);
			}
		}
	}
	public void updateFilme(Integer idFilme, FilmeModel pObjFilme) throws ClassNotFoundException{
		
		objFilme = consultaFilme(idFilme);
		
		if ( objFilme != null)
		{
			try
			{
				Connection connection = ConnectionFactory.getConnection();
				sqlString = "Update Filme set nome_filme=?, ano_producao=? Where idFilme=?";
				
				PreparedStatement smtp = connection.prepareStatement(sqlString);
				smtp.setString(1, pObjFilme.getNome_filme());
				smtp.setString(2, pObjFilme.getAno_producao());
				smtp.setInt(3, idFilme);
				smtp.execute();
			}
			catch (SQLException ex)
			{
				throw new RuntimeException(ex);
			}
		}
	}
}
