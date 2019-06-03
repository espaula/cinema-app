package com.br.cinema.dataAcessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.cinema.connectionFactory.ConnectionFactory;
import com.br.cinema.model.AtorModel;

public class AtorDAO {
	
	private AtorModel objAtor = new AtorModel();
	private String sqlString;
	
	public void insereAtor(AtorModel objAtor) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Insert into ator(nome_ator, idade_ator)"
			  	  + "Values(?,?)";
		try
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, objAtor.getNome_ator());
			smtp.setString(2, objAtor.getIdade_ator());
			smtp.execute();
			smtp.close();
			
			ConnectionFactory.ReleaseConnection(connection);
		}
		catch (SQLException ex)
		{
			throw new RuntimeException(ex);	
		}
		
	}
	public void deleteAtor(AtorModel pObjAtor) throws ClassNotFoundException{
				
		objAtor = consultaAtor(pObjAtor);
		
		if ( objAtor != null ){
			 
			Connection connection = ConnectionFactory.getConnection();
			sqlString = "Delete from Ator Where nome_ator=?";
			
			try 
			{
				PreparedStatement smtp = connection.prepareStatement(sqlString);
				smtp.setString(1, pObjAtor.getNome_ator());
				smtp.execute();
			} 
			catch (SQLException ex) 
			{
				throw new RuntimeException(ex);
			}
		}
	}
	public AtorModel consultaAtor(AtorModel pObjAtor) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Select nome_ator, "
					+ "idade_ator from Ator Where nome_ator=? "
					+ "and idade_ator=?";
		
		try 
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, pObjAtor.getNome_ator());
			smtp.setString(2, pObjAtor.getIdade_ator());
			ResultSet rs = smtp.executeQuery();
				
			while (rs.next()){
				objAtor.setNome_ator(rs.getString(1));
				objAtor.setIdade_ator(rs.getString(2));
			}
			
			smtp.close();
			
		} 
		catch (SQLException ex) 
		{
			throw new RuntimeException(ex);
		}
		
		return objAtor;
	}
	public AtorModel consultaAtor(Integer idAtor) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Select * from Ator Where idator=?";
		
		try 
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setInt(1, idAtor);
			ResultSet rs = smtp.executeQuery();
			
			if ( rs != null){
				objAtor.setNome_ator(rs.getString(1));
				objAtor.setIdade_ator(rs.getString(2));
				smtp.close();
				return objAtor;
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
	public AtorModel consultaAtor(String nomeAtor) throws ClassNotFoundException{

		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Select nome_ator, idade_ator, idator from Ator Where nome_ator=?";
		
		try 
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, nomeAtor);
			ResultSet rs = smtp.executeQuery();
			
			while (rs.next()){

				objAtor.setNome_ator(rs.getString(1));
				objAtor.setIdade_ator(rs.getString(2));
				objAtor.setIdator(Integer.parseInt(rs.getString(3)));
			}

			smtp.close();
			
		}
		catch (SQLException ex) 
		{
			throw new RuntimeException(ex);
		}

		return objAtor;
		
	}
	public void atualizaAtor(Integer idAtor, AtorModel pObjAtor) throws ClassNotFoundException{
			 
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Update Ator set idade_ator=? Where idator=?";
		
		try 
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setString(1, pObjAtor.getIdade_ator());
			smtp.setInt(2, idAtor);
			smtp.execute();
		} 
		catch (SQLException ex) 
		{
			throw new RuntimeException(ex);
		}
	}
}
