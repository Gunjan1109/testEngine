package com.gunjan.app.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService{
	
	@Autowired
	IQuestionHelper questionHelper;
	
	
	public IQuestionHelper getQuestionHelper() {
		return questionHelper;
	}


	public void setQuestionHelper(IQuestionHelper questionHelper) {
		this.questionHelper = questionHelper;
	}

	@Override
	public List getQuestions(String id) {
		// TODO Auto-generated method stub
		List<QuestionsDTO> questionService;
		questionService = questionHelper.getQuestions(id);
		System.out.println(questionService.get(0).getQuestion());
		return questionService;
	}
	
	
}
