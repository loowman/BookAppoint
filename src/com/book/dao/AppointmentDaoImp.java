package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.entity.Appointment;
import com.book.entity.Book;
@Repository("appointDao")
public class AppointmentDaoImp implements  AppointmentDao{
    @Autowired
	private DataSource dataSource;
	@Override
	public int insertAppoint(int bookId, int studentId) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String sql="insert into appointment values(?,?,?)";
		try {
			con=dataSource.getConnection();
		pstmt=con.prepareStatement(sql);
		    pstmt.setInt(1, bookId);
		    pstmt.setInt(2, studentId);
		    pstmt.setDate(3, new java.sql.Date(new Date().getTime()));
//		    set=pstmt.executeQuery();
		    if(!pstmt.execute()){
		    	return 1;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public List<Appointment> queryAndReturn(int studentId) {
		// TODO Auto-generated method stub
		ArrayList<Appointment> list=new ArrayList<Appointment>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		Book book=null;
		Appointment apt=null;
		String sql="select * from appointment natural join book where student_id=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, studentId);
			set=pstmt.executeQuery();
			while(set.next()){
				apt=new Appointment(set.getInt("book_id"),set.getInt("student_id"), set.getDate("appoint_time"));
				book=new Book(set.getInt("book_id"), set.getString("name"), set.getString("introd"),set.getInt("number"));
				apt.setBook(book);
				list.add(apt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
  
}
