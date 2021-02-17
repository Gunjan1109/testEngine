package com.gunjan.app.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gunjan.app.utils.SQLConstants;

class UserMapper implements RowMapper<StudentDTO>{
	
	@Override
	public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		StudentDTO userDTO = new StudentDTO();
		userDTO.setEmail(rs.getString("email"));
		userDTO.setPassword(rs.getString("password"));
		return  userDTO;
		
	}
	
}


@Repository("studentRepo")
public class StudentDAO implements IStudentRepository,SQLConstants{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public boolean login(StudentDTO student) {
		// TODO Auto-generated method stub
		StudentDTO studentTemp;
		try {
			studentTemp = jdbcTemplate.queryForObject(Student_Login,new UserMapper(),student.getEmail(),student.getPassword());
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
		if(studentTemp != null) {
			return true;
		}
		return false;
}
}