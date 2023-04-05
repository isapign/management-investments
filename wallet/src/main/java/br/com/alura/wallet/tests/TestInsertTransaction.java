package br.com.alura.wallet.tests;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

public class TestInsertTransaction {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/wallet?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "317717";
		
		Connection connection = DriverManager.getConnection(url, user, password);

		Transaction t = new Transaction(
				"DFASD12",
				new BigDecimal("12.89"),
				15, 
				LocalDate.of(2023, 04, 01),
				TransactionType.SALE
		);
		
		String insertCommand = "insert into transactions(ticker, price, quantity, date, type) values(?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(insertCommand);
		ps.setString(1, t.getTicker());
		ps.setBigDecimal(2, t.getPrice());
		ps.setInt(3, t.getQuantity());
		ps.setDate(4, Date.valueOf(t.getDate()));
		ps.setString(5, t.getType().toString());

		ps.execute();
	}
}

