package com.imraazrally.autoshop.model.customers;

import java.io.PrintWriter;


public class PrintAjaxResponse extends CustomerAction{
	private final PrintWriter writer;
	private final String message;

	public PrintAjaxResponse(PrintWriter writer, String message) {
		this.writer = writer;
		this.message = message;
	}

	public boolean service() {
		try {
			writer.println(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
