package com.springboot.services;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.Invoice;
import com.springboot.repository.InvoiceRepository;

@Service("invoiceService")
public class InvoiceRepositoryImpl implements InvoiceService{
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public Iterable<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}

	@Override
	public Invoice find(int id) {
		return invoiceRepository.findById(id).get();
	}

}
