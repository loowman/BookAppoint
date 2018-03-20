package com.book.entity;

public class Book {
   private Integer id;
   private String name;
   private String intro;
   private Integer num;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(Integer id, String name, String intro, Integer num) {
	super();
	this.id = id;
	this.name = name;
	this.intro = intro;
	this.num = num;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", intro=" + intro + ", num="
			+ num + "]";
}
   
}
