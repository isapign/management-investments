package br.com.alura.wallet.tests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.wallet.model.Transaction;
import br.com.alura.wallet.model.TransactionType;

public class Test {

	public static void main(String[] args) {
		Transaction t = new Transaction();

		t.setTicker("ITSA4");
		t.setPrice(new BigDecimal("10.0"));
		t.setQuantity(100);
		t.setDate(LocalDate.now());
		t.setType(TransactionType.PURCHASE);

		System.out.println(t.getTicker());
		System.out.println(t.getPrice());
		System.out.println(t.getQuantity());
		System.out.println(t.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(t.getType());

		Transaction t2 = new Transaction("XPTO12", new BigDecimal("12"), 200, LocalDate.now(), TransactionType.SALE);

		System.out.println(t);
		System.out.println(t2);
		
	}

}
