package com.br.cinema.dataAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.cinema.connectionFactory.ConnectionFactory;
import com.br.cinema.model.AtorModel;
import com.br.cinema.model.EscalaModel;
import com.br.cinema.model.FilmeModel;

public class EscalaDAO {

	private AtorModel objAtor;
	private FilmeModel objFilme;
	private String sqlString;
	
	public void insereEscala(EscalaModel pObjEscala) throws ClassNotFoundException{
		
		Connection connection = ConnectionFactory.getConnection();
		sqlString = "Insert into escala(id_filme_escala, id_ator_escala)Values(?,?)";
		
		try
		{
			PreparedStatement smtp = connection.prepareStatement(sqlString);
			smtp.setInt(0, pObjEscala.getId_filme_escala());
			smtp.setInt(1, pObjEscala.getId_ator_escala());
			smtp.execute();
		}
		catch(SQLException ex){
			
			throw new RuntimeException(ex);
		}
	}
	public List<AtorModel> consultaEscala(Integer idFilme) throws ClassNotFoundException{
		
		List<AtorModel> listAtorEscala = new ArrayList<AtorModel>();
		
		try
		{
		
			Connection connection = ConnectionFactory.getConnection();
			sqlString = "Select a.idator, "
			   	  + "a.nome_ator, "
			   	  + "a.idade_ator c.nome_filme c.ano_producao FROM ator a "
			   	  + "INNER JOIN escala b ON b.id_ator_escala = a.idator"
			   	  + "INNER JOIN filme c ON b.id_filme_escala = c.idfilme"
			   	  + "WHERE c.idfile=?";
			   	  
			   	  PreparedStatement smtp = connection.prepareStatement(sqlString);
			   	  smtp.setInt(0, idFilme);
			   	  ResultSet rs = smtp.executeQuery();
				
				if ( rs != null ){
					
					while (rs.next()){
						
						objAtor.setIdator(rs.getInt(0));
						objAtor.setNome_ator(rs.getString(1));
						objAtor.setIdade_ator(rs.getString(2));
						
						listAtorEscala.add(objAtor);
					}
					
				}
		}
		catch (SQLException ex)
		{
			throw new RuntimeException(ex);
		}
		
		return listAtorEscala;
	}
	public List<FilmeModel> consultaEscala(String strNomeAtor) throws ClassNotFoundException{
		
	List<FilmeModel> listaFilme = new ArrayList<FilmeModel>();
		
		try
		{
			Connection connection = ConnectionFactory.getConnection();
			sqlString = "Select a.idator, "
			   	  + "a.nome_ator, "
			   	  + "a.idade_ator c.nome_filme c.ano_producao FROM ator a "
			   	  + "INNER JOIN escala b ON b.id_ator_escala = a.idator"
			   	  + "INNER JOIN filme c ON b.id_filme_escala = c.idfilme"
			   	  + "WHERE a.nome_ator=?";
			   	  
			   	  PreparedStatement smtp = connection.prepareStatement(sqlString);
			   	  smtp.setString(0, strNomeAtor);
			   	  ResultSet rs = smtp.executeQuery();
				
				if ( rs != null ){
					
					while (rs.next()){
						
						objFilme.setNome_filme(rs.getString(3));
						objFilme.setAno_producao(rs.getString(4));
						
						listaFilme.add(objFilme);
					}
					
				}
		}
		catch (SQLException ex){
			throw new RuntimeException(ex);
		}
		
		return listaFilme;
	}
	public void deleteEscala(Integer idFilme){
	
		try 
		{
			FilmeDAO objFilmeDao = new FilmeDAO();
			objFilmeDao.consultaFilme(idFilme);
			
			if ( objFilmeDao != null)
			{		 
				try
				{
					Connection connection = ConnectionFactory.getConnection();
					sqlString = "Delete from escala where id_filme_escala=?";
						
				PreparedStatement smtp = connection.prepareStatement(sqlString);
				smtp.setInt(0, idFilme);
				smtp.execute();
				}
				catch (SQLException ex){
					throw new RuntimeException(ex);
				}
			}			
		} 
		catch (ClassNotFoundException ex) {
			
			throw new RuntimeException(ex);
		}
	}
}
