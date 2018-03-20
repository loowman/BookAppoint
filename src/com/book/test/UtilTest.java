package com.book.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.book.dao.AppointmentDao;
import com.book.dao.BookDao;
import com.book.dao.StudentDao;
import com.book.entity.Appointment;
import com.mysql.jdbc.Connection;

public class UtilTest {
   private ApplicationContext ctx;
   {
	   ctx=new ClassPathXmlApplicationContext("SpringConfig.xml");
   }
	@Test
	public void test() throws SQLException {
//		  DataSource con=(DataSource) ctx.getBean("dataSource");
//		  System.out.println(con.getConnection());
//		  System.out.println(con);
		BookDao bDao=(BookDao) ctx.getBean("bookDao");
		System.out.println(bDao.queryByName("大学"));
//		AppointmentDao aDao=(AppointmentDao) ctx.getBean("appointDao");
//		System.out.println(aDao.queryAndReturn(32112801));
//		ArrayList<Appointment> list=(ArrayList<Appointment>) aDao.queryAndReturn(32112801);
//		for(Appointment a:list){
//			System.out.println(a.toString());
//			System.out.println(a.getBook().toString());
		
//		}
//		StudentDao sDao=(StudentDao) ctx.getBean("studentDao");
//		System.out.println(sDao.queryById(32112801, "34653"));
	}

}
