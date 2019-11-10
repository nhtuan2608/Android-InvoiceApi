package com.springboot.services;

import com.springboot.entities.Invoice;

public interface InvoiceService {
	public Iterable<Invoice> findAll();
	
	public Invoice save(Invoice invoice);

	public void delete(int id);
	
	public Invoice find(int id);
}
