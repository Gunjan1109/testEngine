package com.gunjan.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sServiceObj")
public class StudentService implements IStudentComponent,IStudent{
	
	@Autowired
	private IStudentComponent studentCom;
	
	public IStudentComponent getStudentCom() {
		return studentCom;
	}

	public void setStudentCom(IStudentComponent studentCom) {
		this.studentCom = studentCom;
	}


	@Override
	public boolean login(StudentDTO student) {
		
		// TODO Auto-generated method stub
		boolean checkCredentials =  studentCom.login(student);
		return checkCredentials;
	}
	
}
 