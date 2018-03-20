package com.book.entity;

public class Student {
   private Integer id;
   private String password;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(Integer id, String password) {
	super();
	this.id = id;
	this.password = password;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Student [id=" + id + ", password=" + password + "]";
}
   
}
