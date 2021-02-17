package com.gunjan.app.test;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.gunjan.app.questions.IQuestion;
import com.gunjan.app.questions.IQuestionService;
import com.gunjan.app.utils.Utility;
import com.gunjan.app.questions.QuestionService;
import com.gunjan.app.questions.QuestionsDTO;;
@Service
public class TestService implements ITest{
	
	@Autowired
	private TestHelper testComponent;
	
	public TestHelper getTestComponent() {
		return testComponent;
	}
	
	@Autowired
	private IQuestionService questionService;
	
	public IQuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public void setTestComponent(TestHelper testComponent) {
		this.testComponent = testComponent;
	}

	@Override
	public void showTest(String testChoice) {
		// TODO Auto-generated method stub
		
		int score = 0;
		List<QuestionsDTO> questionList;
			questionList =  questionService.getQuestions(testChoice);
			
			for(QuestionsDTO temp : questionList) {
				String userAnswer;
				System.out.println("Q" +": " + temp.getQuestion());
				System.out.println("1. "+ temp.getOption1());
				System.out.println("2. " + temp.getOption2());
				System.out.println("3. " + temp.getOption3());
				System.out.println("4. " + temp.getOption4());
				
				userAnswer = Utility.sc.nextLine();
				
				if(userAnswer.equals(temp.getCorrectAnswer())){
					score += 5;
					System.out.println("Correct!!! Your score is " + score);
				}
				else {
					System.out.println("Wrong! Your score is " + score);
				}
				
			}
			
			System.out.println("Test is over\nYour total score is " + score);
			
	}


	
	
}
