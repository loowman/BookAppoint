package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.book.entity.Book;



@Repository(value="bookDao")
public class BookDaoImp implements BookDao{
  @Autowired
	private DataSource dataSource;
   
	@Override
	public Book queryById(int id) {
		// TODO Auto-generated method stub
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("SpringConfig.xml");
//		dataSource=(DataSource) ctx.getBean("dataSource");
//		System.out.println(dataSource);
		Book book=null;
		String sql="select * from book where book_id=?";
		Connection con=null;
//		PreparedStatement pstmt=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
	
			try {
				con=dataSource.getConnection();
				//System.out.println(con);
		 pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, id);
			set=pstmt.executeQuery();
			if(set.next()){
				book=new Book(set.getInt("book_id"),set.getString("name"),set.getString("introd"),set.getInt("number"));
				//System.out.println(book);
				return book;
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
		
		
		
		
		return book;
	}

	@Override
	public List<Book> queryByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select * from book where name like ?";
		Book book=null;
		Connection con=null;
//		PreparedStatement pstmt=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
	
			try {
				con=dataSource.getConnection();
				//System.out.println(con);
		 pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			set=pstmt.executeQuery();
			while(set.next()){
				book=new Book(set.getInt("book_id"),set.getString("name"),set.getString("introd"),set.getInt("number"));
				System.out.println(book);
				//return book;
				list.add(book);
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

	@Override
	public List<Book> queryAll(int offset, int limit) {
		// TODO Auto-generated method stub
		ArrayList<Book> list=new ArrayList<Book>();
		String sql="select * from book order by book_id limit ?,?";
		Book book=null;
		Connection con=null;
//		PreparedStatement pstmt=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
	
			try {
				con=dataSource.getConnection();
				//System.out.println(con);
		 pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1,offset);
			pstmt.setInt(2, limit);
			set=pstmt.executeQuery();
			while(set.next()){
				book=new Book(set.getInt("book_id"),set.getString("name"),set.getString("introd"),set.getInt("number"));
				//System.out.println(book);
				//return book;
				list.add(book);
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

	@Override
	public int reduceNumber(Integer id) {
		// TODO Auto-generated method stub
		Connection con=null;
//		PreparedStatement pstmt=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String sql="update book set number=number-1 where book_id=? and number>0";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int row=pstmt.executeUpdate();
			if(row>0){
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

}
