package com.book.service;

import java.util.List;

import com.book.dao.StudentDao;
import com.book.dto.AppointExecution;
import com.book.entity.Appointment;
import com.book.entity.Book;

public interface BookService {
      public Book getById(int id);
      
      public List<Book> getList();
      
      public int validateStu(int id,String password);
      public List<Appointment> getAppointByStu(int studentId);
      public List<Book>  getListByName(String name);
      public AppointExecution appoint(int bookId, int studentId)throws Exception;//返回预约成功的实体类
}
