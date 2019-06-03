package com.br.cinema.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String strConnection;
	private static String strUser;
	private static String strPassword;
	
	public static Connection getConnection() throws ClassNotFoundException
	{
		strConnection = "jdbc:mysql://localhost/cinema"; 
		strUser = "root";
		strPassword = "root";		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(strConnection, strUser, strPassword);
			return conn;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		
	}
	
	public static void ReleaseConnection(Connection conn) {
		if ( conn != null)
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}
