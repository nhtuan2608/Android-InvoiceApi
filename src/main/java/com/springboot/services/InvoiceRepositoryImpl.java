package com.springboot.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public Iterable<Invoice> search(String keyword, String year, String month) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("Keyword: " + keyword);
		System.out.println("Year: " + year);
		System.out.println("Month: " + month);
		
		List<Invoice> invoiceListSorted = new ArrayList<Invoice>();
		for(Invoice obj: invoiceRepository.findAll()) {
			String date = dateFormat.format(obj.getCreatedDate());
			String yearSub = date.substring(0,4);
			String monthSub = date.substring(5, 7);
			
			if (!keyword.equalsIgnoreCase("null")) {
				if(obj.getStatus().equalsIgnoreCase(keyword)) {
					invoiceListSorted.add(obj);
				}
			} else if (yearSub.equalsIgnoreCase(year) && monthSub.equalsIgnoreCase(month)) {
				invoiceListSorted.add(obj);
			}
		}
		for(Invoice obj: invoiceListSorted) {
			System.out.println(" Search ---------- " + obj);
		}
		return invoiceListSorted;
	}

}
