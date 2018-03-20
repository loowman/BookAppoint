package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("studentDao")
public class StudentDaoImp implements StudentDao{
	  @Autowired
		private DataSource dataSource;
	@Override
	public int queryById(int studentId, String password) {
		// TODO Auto-generated method stub
		Connection con=null;
//		PreparedStatement pstmt=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String sql="select count(*) from student where student_id=? and password=?";
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, studentId);
			pstmt.setString(2, password);
			set=pstmt.executeQuery();
			if(set.next()){
//				System.out.println(set.getInt(1));
				if(set.getInt(1)!=0)
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
