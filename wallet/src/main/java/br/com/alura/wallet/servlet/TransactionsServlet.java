package br.com.alura.wallet.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.wallet.dao.TransactionDao;
import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;
import br.com.alura.wallet.factory.ConnectionFactory;

@WebServlet("/transactions")
public class TransactionsServlet extends HttpServlet {
	
	private TransactionDao dao;
	
	public TransactionsServlet() {
		this.dao = new TransactionDao(new ConnectionFactory().getConnection());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			req.setAttribute("transactions", dao.list());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("WEB-INF/jsp/transactions.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String ticker = req.getParameter("ticker");
			LocalDate date = LocalDate.parse(req.getParameter("date"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			BigDecimal price = new BigDecimal(req.getParameter("price").replace(",", "."));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			TransactionType type = TransactionType.valueOf(req.getParameter("type"));

			Transaction transaction = new Transaction(
					ticker,
					price,
					quantity,
					date,
					type
			);

			try {
				dao.register(transaction);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("transactions");
		} catch (NumberFormatException e) {
			resp.sendRedirect("transactions?error=wrong format fields");
		}
	}
}
