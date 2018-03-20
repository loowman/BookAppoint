package com.book.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.AppointmentDao;
import com.book.dao.BookDao;
import com.book.dao.StudentDao;
import com.book.dto.AppointExecution;
import com.book.entity.Appointment;
import com.book.entity.Book;
import com.book.enums.AppointStateEnum;
import com.book.exception.AppointException;
import com.book.exception.NoNumberException;
import com.book.exception.RepeatAppointException;

@Service
public class BookServiceImp implements BookService{
    
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		
		 
		
		return bookDao.queryById(id);
	}

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookDao.queryAll(0, 100);
	}

	@Override
	public int validateStu(int id, String password) {
		// TODO Auto-generated method stub
		return studentDao.queryById(id, password);
	}

	@Override
	public List<Book> getListByName(String name) {
		// TODO Auto-generated method stub
		return bookDao.queryByName(name);
	}

	@Override
	public AppointExecution appoint(int bookId, int studentId) throws Exception {
		// TODO Auto-generated method stub
		
		try{
		int update=bookDao.reduceNumber(bookId);
		if(update==0){
			throw new NoNumberException("No Number");
		}else{
			int insert=appointmentDao.insertAppoint(bookId, studentId);
			if(insert==0){
				throw new RepeatAppointException("重复预约");
			}else{
				return new AppointExecution(bookId, AppointStateEnum.SUCCESS);
			}
		}
		}catch(Exception e){
			throw new AppointException("预约 异常");
		}
		
		
	}

	@Override
	public List<Appointment> getAppointByStu(int studentId) {
		// TODO Auto-generated method stub
		return appointmentDao.queryAndReturn(studentId);
	}

}
