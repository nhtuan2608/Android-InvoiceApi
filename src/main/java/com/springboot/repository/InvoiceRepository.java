package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Invoice;

@Repository("invoiceRepository")
public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

}
