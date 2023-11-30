package com.jaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection conectar() {
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb1", "lleandrroo", "123Qwe!@#");
		} catch (SQLException e) {				
			throw new RuntimeException("Erro de Conexão: " + e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver não localizado: " + e);
		}
	}

}
