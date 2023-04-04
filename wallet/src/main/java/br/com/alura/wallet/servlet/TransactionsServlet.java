package br.com.alura.wallet.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;

@WebServlet("/transactions")
public class TransactionsServlet extends HttpServlet {
	
	private List<Transaction> transactions = new ArrayList<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Transaction t1 = new Transaction("XPTO12", new BigDecimal("12"), 200, LocalDate.now(), TransactionType.SALE);
		Transaction t2 = new Transaction("IA2HD", new BigDecimal("120.07"), 6, LocalDate.now(), TransactionType.PURCHASE);
		
		transactions.add(t1);
		transactions.add(t2);
		
		req.setAttribute("transactions", transactions);
		
		req.getRequestDispatcher("WEB-INF/jsp/transactions.jsp").forward(req, resp);
	}
}
