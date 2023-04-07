package br.com.alura.wallet.tests;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.wallet.dao.TransactionDao;
import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;


public class TestInsertTransaction {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/wallet?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "317717";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		TransactionDao dao = new TransactionDao(connection);
		
		Transaction transaction = new Transaction(
				"XPTO",
				new BigDecimal("123.33"),
				102,
				LocalDate.now(),
				TransactionType.PURCHASE
			);

		dao.register(transaction);
	}
}
