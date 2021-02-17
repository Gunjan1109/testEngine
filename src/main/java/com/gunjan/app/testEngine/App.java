package com.gunjan.app.testEngine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gunjan.app.questions.IQuestionHelper;
import com.gunjan.app.questions.IQuestionService;
import com.gunjan.app.student.IStudent;
import com.gunjan.app.student.StudentDTO;
import com.gunjan.app.test.ITest;
import com.gunjan.app.utils.Utility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
    	IStudent studentService =(IStudent) ac.getBean("sServiceObj");
    	StudentDTO student = (StudentDTO) ac.getBean("studentDTO");
        System.out.println("Enter email");
        student.setEmail(Utility.sc.next());
        System.out.println("Enter password");
        student.setPassword(Utility.sc.next());
        boolean checkCredentials =  studentService.login(student);
        
        if(checkCredentials) {
        	System.out.println("Select 1 of the Following Test\n1.C\n2.Java");
    		String testChoice = Utility.sc.next();
    		
//    		IQuestionHelper question = (IQuestionHelper) ac.getBean("questionHelper");
//    		question.getQuestions(testChoice);
//        	
//    		IQuestionService question = (IQuestionService) ac.getBean("questionService");
//    		question.getQuestions(testChoice);
    		
    		ITest test = (ITest) ac.getBean("testService");
    		test.showTest(testChoice);
        }
        else {
        	System.out.println("Wrong Information");
        	System.exit(0);
        }
        
    }
}
