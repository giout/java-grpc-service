package com.grpc.microservice.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cnn 
{
	public Connection connection = null;
	
	public void createConnection()
	{
        // url = jdbc:<dbms>://<host>:<port>/<database>
		try
		{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", 
				"postgres", 
				"tulli1467");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
