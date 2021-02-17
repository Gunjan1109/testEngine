package com.gunjan.app.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionHelper implements IQuestionHelper{
	
	@Autowired
	IQuestionDAO questions;
	
	public IQuestionDAO getQuestions() {
		return questions;
	}

	public void setQuestions(IQuestionDAO questions) {
		this.questions = questions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getQuestions(String id) {
		// TODO Auto-generated method stub
		List<QuestionsDTO> questionDTO;
		questionDTO =  questions.getQuestions(id);
		//System.out.println(questionDTO.get(0).getQuestion());
		return questionDTO;
	}

}
