package com.book.entity;

import java.util.Date;

public class Appointment {
    private Integer b_id;
    private Integer s_id;
    private Date date;
    private Book book;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Integer b_id, Integer s_id, Date date) {
		super();
		this.b_id = b_id;
		this.s_id = s_id;
		this.date = date;
	}
	public Integer getB_id() {
		return b_id;
	}
	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [b_id=" + b_id + ", s_id=" + s_id + ", date="
				+ date + "]";
	}
    
}
