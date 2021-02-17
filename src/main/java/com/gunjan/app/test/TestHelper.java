package com.gunjan.app.test;

import org.springframework.stereotype.Component;

@Component("testComponent")
public class TestHelper implements ITestComponent{

	@Override
	public void showTest(int testChoice) {
		// TODO Auto-generated method stub
		if(testChoice == 1) {
			
		}
	}

}
