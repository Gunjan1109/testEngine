package com.gunjan.app.questions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gunjan.app.utils.SQLConstants;


class UserMapper implements RowMapper<QuestionsDTO>{
	
	@Override
	public QuestionsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		QuestionsDTO questionsDTO = new QuestionsDTO();
		questionsDTO.setQuestion(rs.getString("question"));
		questionsDTO.setOption1(rs.getString("option1"));
		questionsDTO.setOption2(rs.getString("option2"));
		questionsDTO.setOption3(rs.getString("option3"));
		questionsDTO.setOption4(rs.getString("option4"));
		questionsDTO.setCorrectAnswer(rs.getString("correctAnswer"));
		return  questionsDTO;
		
	}
	
}

@Repository
public class QuestionDAO implements SQLConstants,IQuestionDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getQuestions(String id) {
		List<QuestionsDTO> questions;
		try {
			questions = jdbcTemplate.query(Question_Query, new UserMapper(),id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return questions;
	}
	
}
