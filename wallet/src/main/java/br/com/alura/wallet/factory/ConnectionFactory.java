package br.com.alura.wallet.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/wallet?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String password = "317717";
			
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
