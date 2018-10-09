package com.sankar.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sankar.spring.entity.Emp;

@Repository
//Important to use Repository type
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String save(Emp e) {
		String response="";
		try {
		String insert_sql="insert into EMP(empno,name,address,salary) values (?,?,?,?)";
		int count1=jt.update(con-> {
			PreparedStatement pst=con.prepareStatement(insert_sql);
			pst.setInt(1, e.getEmpId());
			pst.setString(2,e.getName());
			pst.setString(3,e.getCity());
			pst.setDouble(4, e.getSalary());
			
			return pst;
		});
			response="Hurray! Saved the Data";
		}
		//catch(DataAccessException e1){
		catch(DuplicateKeyException e1){
			//e1.printStackTrace();
			response="Data Not Saved - Duplicate";
			
		}
		return response;
	}

	@Override
	public String delete(int id) {
		int count=jt.update(c->{
			PreparedStatement pst = c.prepareStatement("delete from emp where empno="+id);
			return pst;
		});
		
		if (count==1) {
			return "emp deleted";
		}else {
			return "emp not deleted";
		}
				
	}

	@Override
	public Emp findById(int id) {
		
	
		Emp e =jt.queryForObject("select * from emp where empno="+id, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
			}
			
		});
		
		return e;
		
		
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> e =jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
			}
			
		});
		
		return e;

	}

}
