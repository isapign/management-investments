package br.com.alura.wallet.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
	private String ticker;
	private BigDecimal price;
	private int quantity;
	private LocalDate date;
	private TransactionType type;
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Java é top";
//	}

	@Override
	public String toString() {
		return "Transaction [ticker=" + ticker + ", price=" + price + ", quantity=" + quantity + ", date=" + date
				+ ", type=" + type + "]";
	}

	public Transaction() {} // dessa forma permite que seja instanciado sem exigir parâmetros

	public Transaction(String ticker, BigDecimal price, int quantity, LocalDate date, TransactionType type) {
		super();
		this.ticker = ticker;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.type = type;
	} // dessa forma ele aceita a instância com os parâmetros

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

}
