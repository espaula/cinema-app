package com.br.cinema.teste;

import java.sql.Connection;
import java.sql.SQLException;

import com.br.cinema.connectionFactory.ConnectionFactory;
import com.br.cinema.dataAcessObject.AtorDAO;
import com.br.cinema.model.AtorModel;

public class ConnectionTest {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Connection connection = ConnectionFactory.getConnection();
		
		AtorModel objAtorModel = new AtorModel();
		objAtorModel.setIdade_ator("50");
		objAtorModel.setNome_ator("Teste");
		
		AtorDAO objAtorDAO = new AtorDAO();
		
		objAtorDAO.atualizaAtor(1, objAtorModel);
		
		
		
		System.out.println("Conectou ::: " + connection.toString());
		ConnectionFactory.ReleaseConnection(connection);
	}
}

