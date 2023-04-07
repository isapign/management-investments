package br.com.alura.wallet.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.wallet.dao.TransactionDao;
import br.com.alura.wallet.model.Transaction;

public class TestSelectTransaction {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/wallet?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "317717";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		TransactionDao dao = new TransactionDao(connection);
		
		List<Transaction> transactions = dao.list();
		
		transactions.forEach(System.out::println);
	}
}
