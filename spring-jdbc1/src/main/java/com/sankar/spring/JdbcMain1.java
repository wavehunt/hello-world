package com.sankar.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcMain1 {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt=ctx.getBean(JdbcTemplate.class);
		
		String insert_sql="insert into EMP(empno,name,address,salary) values (?,?,?,?)";
		int count=jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pst=con.prepareStatement(insert_sql);
				pst.setInt(1, 107);
				pst.setString(2,"Sankar");
				pst.setString(3,"Kukatpally");
				pst.setDouble(4, 50000);
				
				return pst;
			}
		});
		
		System.out.println("Rows Inserted: " + count);
		
		//Lambda way
		int count1=jt.update(con-> {
				PreparedStatement pst=con.prepareStatement(insert_sql);
				pst.setInt(1, 108);
				pst.setString(2,"Harish");
				pst.setString(3,"USA");
				pst.setDouble(4, 50000);
				
				return pst;
			});
		
		System.out.println("Rows Inserted: " + count1);
		
	}

}
