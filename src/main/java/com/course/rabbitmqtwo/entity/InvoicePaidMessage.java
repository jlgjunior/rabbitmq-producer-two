package com.course.rabbitmqtwo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class InvoicePaidMessage {

	private String invoiceNumber;
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate paidDate;
	private String paymentNumber;

	public InvoicePaidMessage() {

	}

	public InvoicePaidMessage(String invoiceNumber, LocalDate paidDate, String paymentNumber) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.paidDate = paidDate;
		this.paymentNumber = paymentNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	@Override
	public String toString() {
		return "InvoicePaidMessage [invoiceNumber=" + invoiceNumber + ", paidDate=" + paidDate + ", paymentNumber="
				+ paymentNumber + "]";
	}
}
