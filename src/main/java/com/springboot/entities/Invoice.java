package com.springboot.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "invoice")
@Document(collection = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String payment;
	private String status;
	@CreatedDate
	@Column(name="createdDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(int id, String name, String payment, String status, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.payment = payment;
		this.status = status;
		this.createdDate = createdDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", name=" + name + ", payment=" + payment + ", status=" + status + ", createdDate="
				+ createdDate + "]";
	}
	
	
}
