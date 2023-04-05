package br.com.alura.wallet.tests;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;

public class TestSelectTransaction {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/wallet?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "317717";
		
		Connection connection = DriverManager.getConnection(url, user, password);

		String selectCommand = "select * from transactions";
		
		PreparedStatement ps = connection.prepareStatement(selectCommand);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Transaction t = new Transaction();
			t.setTicker(rs.getString("ticker"));
			t.setDate(rs.getDate("date").toLocalDate());
			t.setPrice(rs.getBigDecimal("price"));
			t.setQuantity(rs.getInt("quantity"));
			t.setType(TransactionType.valueOf(rs.getString("type")));
			
			System.out.println(t);
		}
	}
}
