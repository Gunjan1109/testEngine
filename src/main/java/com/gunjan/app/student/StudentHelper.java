package com.gunjan.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentCom")
public class StudentHelper implements IStudentComponent{
	
	@Autowired
	private IStudentRepository studentRepo;	
	
	public IStudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(IStudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	


	@Override
	public boolean login(StudentDTO student) {
		// TODO Auto-generated method stub
		boolean checkCredentials =  studentRepo.login(student);
		return checkCredentials;
	}
}
