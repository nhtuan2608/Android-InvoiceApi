package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entities.Invoice;
import com.springboot.services.InvoiceService;;

@RestController
@RequestMapping("api/invoices")
public class InvoiceRestController {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Invoice>> findAll() {
		try {
			System.out.println("-------------- " + invoiceService.findAll());
			return new ResponseEntity<Iterable<Invoice>>(invoiceService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Iterable<Invoice>>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invoice> find(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Invoice>(invoiceService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		String mesg;
		try {
			invoiceService.delete(id);
			mesg = "Deleted." ;
			return new ResponseEntity<String>(mesg,HttpStatus.OK);

		} catch (Exception e) {
			mesg = "Failed to Delete.";
			return new ResponseEntity<String>(mesg,HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) {

		try {
			System.out.println("-------------- " + invoice);
			invoice = invoiceService.save(invoice);
			return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Invoice>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(	@RequestBody Invoice invoice) {

		try {
			invoice = invoiceService.save(invoice);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
