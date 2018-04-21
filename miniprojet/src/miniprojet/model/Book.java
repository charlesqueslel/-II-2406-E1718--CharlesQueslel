package miniprojet.model;

import java.io.Serializable;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean reserv;
	private String borrower;
	
	public Book(String name) {
		
		this.name=name;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReserv() {
		return reserv;
	}

	public void setReserv(boolean reserv) {
		this.reserv = reserv;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	
}
