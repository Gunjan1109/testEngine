package com.gunjan.app.utils;

public interface SQLConstants {
	String Student_Login = "select email,password from Student where email=? and password=?";
	String Question_Query = "select question,option1,option2,option3,option4,correctAnswer from Test where id=?";
}
