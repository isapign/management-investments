package br.com.alura.wallet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;

public class TransactionDao {
	
	private Connection connection;
	
	public TransactionDao(Connection connection) {
		this.connection = connection;
	}

	public void register(Transaction transaction) throws SQLException {
		
		String insertCommand = "insert into transactions(ticker, price, quantity, date, type) values(?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(insertCommand);
		ps.setString(1, transaction.getTicker());
		ps.setBigDecimal(2, transaction.getPrice());
		ps.setInt(3, transaction.getQuantity());
		ps.setDate(4, Date.valueOf(transaction.getDate()));
		ps.setString(5, transaction.getType().toString());

		ps.execute();
	}
	
	public List<Transaction> list() throws SQLException {

		String selectCommand = "select * from transactions";
		
		PreparedStatement ps = connection.prepareStatement(selectCommand);
		
		ResultSet rs = ps.executeQuery();
		
		List<Transaction> transactions = new ArrayList<>();
		
		while(rs.next()) {
			Transaction t = new Transaction();
			t.setTicker(rs.getString("ticker"));
			t.setDate(rs.getDate("date").toLocalDate());
			t.setPrice(rs.getBigDecimal("price"));
			t.setQuantity(rs.getInt("quantity"));
			t.setType(TransactionType.valueOf(rs.getString("type")));
			
			transactions.add(t);
		}

		return transactions;
	}

}
